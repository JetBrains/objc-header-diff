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

fun parseGroupToken(source: String, pointer: Int = 0): GroupToken {

    var idx = pointer

    fun traverse(s: String): GroupToken {
        val result = mutableListOf<GroupToken>()
        var name = ""

        while (isInRange(s, idx)) {
            val ch = s[idx]
            idx++
            if (isOpening(ch)) {
                result.add(traverse(s))
            } else if (isClosing(ch)) {
                return makeGroupToken(name, result)
            } else {
                name += ch
            }
        }

        return makeGroupToken(name, result)
    }

    return traverse(source)
}

private fun makeGroupToken(
    name: String,
    result: MutableList<GroupToken>
) = GroupToken(name.trim(), result)

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