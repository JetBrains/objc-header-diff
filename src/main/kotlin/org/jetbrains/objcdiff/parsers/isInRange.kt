package org.jetbrains.objcdiff.parsers

fun isInRange(source: String, pointer: Int): Boolean {
    return pointer <= source.length - 1
}

fun isInRangeOrError(source: String, pointer: Int): Boolean {
    if (pointer <= source.length - 1) return true
    error("Outside of range")
}

fun String.isOutOfRange(pointer: Int): Boolean {
    return pointer > this.length - 1
}