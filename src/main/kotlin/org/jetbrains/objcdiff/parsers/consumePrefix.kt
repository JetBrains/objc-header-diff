package org.jetbrains.objcdiff.parsers

fun String.consumePrefix(
    prefixRegex: String,
    handlePrefix: (String?) -> Unit
): String {

    val regex = Regex("^($prefixRegex)")
    val matchResult = regex.find(this)

    return if (matchResult != null) {
        val prefix = matchResult.value
        handlePrefix(prefix)
        this.substring(prefix.length)
    } else {
        handlePrefix(null)
        this
    }
}
