package org.jetbrains.objcdiff.parsers

fun String?.dropBracketsOrError(): String {
    if (this == null) error("Expected brackets string, actual: null")
    if (this.length < 2) error("Expected brackets string, actual: $this")
    if (this[0] != '(' || this[this.length - 1] != ')') error("Expected brackets string, actual: $this")
    return this.drop(1).dropLast(1)
}

fun String?.dropLastBracketsWithContent(): String? {
    if (this.isNullOrEmpty()) return this
    if (this.length <= 2) return this
    if (this.last() != ')') return this
    var i = this.length - 2
    var count = 1
    while (i >= 0) {
        val ch = this[i]
        if (ch == ')') {
            count++
        } else if (ch == '(') {
            count--
        }

        if (count == 0) return this.substring(0, i)

        i--
    }

    return this
}