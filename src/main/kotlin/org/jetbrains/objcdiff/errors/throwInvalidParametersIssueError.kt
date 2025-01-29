package org.jetbrains.objcdiff.errors

internal fun throwInvalidParametersIssueError(size: Int): Nothing {
    error("\nInvalid amount of arguments, expected 2, actual: $size")
}