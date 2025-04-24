package org.jetbrains.objcdiff.parsers

import org.jetbrains.objcdiff.parsers.ObjCGroupType.*

fun parseTokenGraph(source: String): List<ObjCTokenNode> {
    var i = 0
    fun traverse(): List<ObjCTokenNode> {

        val children = mutableListOf<ObjCTokenNode>()
        var child = ""

        fun consumeChild(ch: List<ObjCTokenNode> = emptyList(), forceConsume: Boolean = false): Boolean {
            if (child.isNotEmpty() || forceConsume) {
                children.add(ObjCTokenNode(child, ch))
                child = ""
                return true
            } else return false
        }

        while (isInRange(source, i)) {
            val ch = source[i++]
            if (isOpening(ch)) {
                val traverseResult = traverse()
                val consumed = consumeChild(traverseResult, true)
                if (!consumed) {
                    children.addAll(traverseResult)
                }
            } else if (isClosing(ch)) {
                consumeChild()
                return children
            } else {
                if (ch.isBreak()) {

                    if(ch == ',' && source.getOrNull(i) == ' ') i++ // consume child after ", " case

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

data class ObjCTokenNode(
    val name: String,
    val children: List<ObjCTokenNode> = emptyList()
) {
    constructor(name: String, child: ObjCTokenNode) : this(name, listOf(child))
}

private sealed class ObjCGroupType(
    val open: Char, val close: Char
) {
    data object Curly : ObjCGroupType('{', '}')
    data object Parent : ObjCGroupType('(', ')')
    data object Square : ObjCGroupType('[', ']')
    data object Cone : ObjCGroupType('<', '>')
}

private fun Char.isBreak(): Boolean {
    return this == ' ' || this == ','
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