package org.jetbrains.objcdiff.parsers

fun splitSelectors(source: String): List<SelectorItem> {
    val result = mutableListOf<SelectorItem>()
    var i = 0
    var mode = SelectorLocation.PRE_NAME

    var prefix = ""
    var type = ""
    var postfix = ""
    var bracketDepth = 0

    while (isInRange(source, i)) {
        val ch = source[i]
        if (ch == '(') {
            if (bracketDepth == 0) mode = SelectorLocation.TYPE
            bracketDepth++
            if (mode == SelectorLocation.TYPE && bracketDepth >= 2) type += ch //add nested type brackets
        } else if (ch == ')') {
            if (bracketDepth == 1) mode = SelectorLocation.POST_NAME
            bracketDepth--
            if (mode == SelectorLocation.TYPE && bracketDepth <= 2) type += ch //add nested type brackets
        } else if (ch == ':') {
            bracketDepth = 0
            mode = SelectorLocation.DIVIDER
        } else if (ch == ' ') {
            if (mode == SelectorLocation.POST_NAME) {
                mode = SelectorLocation.PRE_NAME
                result.add(SelectorItem(prefix, type, postfix))
                prefix = ""
                type = ""
                postfix = ""
            } else if (mode == SelectorLocation.TYPE) {
                type += ch
            }
        } else {
            when (mode) {
                SelectorLocation.PRE_NAME -> prefix += ch
                SelectorLocation.TYPE -> type += ch
                SelectorLocation.POST_NAME -> postfix += ch
                else -> Unit
            }
        }

        i++
    }

    result.add(SelectorItem(prefix, type, postfix))

    return result
}

data class SelectorItem(val prefix: String, val type: String, val postfix: String)

private enum class SelectorLocation {
    PRE_NAME, DIVIDER, TYPE, POST_NAME
}