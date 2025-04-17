package org.jetbrains.objcdiff.parsers

import org.jetbrains.objcdiff.parsers.ObjCGroupType.*

sealed class ObjCGroupType(
    val open: Char, val close: Char
) {
    data object Curly : ObjCGroupType('{', '}')
    data object Parent : ObjCGroupType('(', ')')
    data object Square : ObjCGroupType('[', ']')
    data object Cone : ObjCGroupType('<', '>')
}

data class GroupToken(
    val name: String,
    val children: List<GroupToken> = emptyList()
) {
    constructor(name: String, child: GroupToken) : this(name, listOf(child))
}

fun Char.isBreak(): Boolean {
    return this == ' '
}

fun parseGroupToken(source: String, pointer: Int = 0): List<GroupToken> {

    var idx = pointer

    fun traverse(): List<GroupToken> {

        val children = mutableListOf<GroupToken>()
        var child = ""

        fun consumeChild(ch: List<GroupToken> = emptyList(), forceConsume: Boolean = false): Boolean {
            if (child.isNotEmpty() || forceConsume) {
                children.add(GroupToken(child, ch))
                child = ""
                return true
            } else return false
        }

        while (isInRange(source, idx)) {
            val ch = source[idx++]
            if (isOpening(ch)) {
                val chch = traverse()
                val consumed = consumeChild(chch, true)
                if (!consumed) {
                    children.addAll(chch)
                }
            } else if (isClosing(ch)) {
                consumeChild()
                return children
            } else {
                if (ch.isBreak()) {
                    consumeChild()
                } else {
                    child += ch
                }
            }
        }

        consumeChild()

        return children
    }

    return traverse()
}

private fun isOpening(ch: Char): Boolean {
    return ch.getOpeningOrNull() != null
}

private fun isClosing(ch: Char): Boolean {
    return ch.getClosingOrNull() != null
}

private fun Char.getOpeningOrNull(): ObjCGroupType? {
    if (this == Curly.open) return Curly
    if (this == Parent.open) return Parent
    if (this == Square.open) return Square
    if (this == Cone.open) return Cone
    return null
}

private fun Char.getClosingOrNull(): ObjCGroupType? {
    if (this == Curly.close) return Curly
    if (this == Parent.close) return Parent
    if (this == Square.close) return Square
    if (this == Cone.close) return Cone
    return null
}