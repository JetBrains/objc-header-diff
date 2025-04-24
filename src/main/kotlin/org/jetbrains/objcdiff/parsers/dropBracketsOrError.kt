package org.jetbrains.objcdiff.parsers

fun String?.dropBracketsOrError(): String {
    if (this == null) error("Expected brackets string, actual: null")
    if (this.length < 2) error("Expected brackets string, actual: $this")
    if (this[0] != '(' || this[this.length - 1] != ')') error("Expected brackets string, actual: $this")
    return this.drop(1).dropLast(1)
}