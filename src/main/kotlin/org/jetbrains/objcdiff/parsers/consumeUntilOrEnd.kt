package org.jetbrains.objcdiff.parsers

fun consumeUntilOrEnd(target: Char, source: String, pointer: Int, onResult: (String, Int) -> Unit) {
    var i = pointer
    val sb = StringBuilder()
    while (source[i] != target) {
        sb.append(source[i])
        i++
        if (!isInRange(source, i)) {
            onResult(sb.toString(), i)
            return
        }
    }
    onResult(sb.toString(), i + 1)
}