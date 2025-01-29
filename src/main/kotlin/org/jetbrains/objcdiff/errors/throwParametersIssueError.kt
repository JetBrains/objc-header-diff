package org.jetbrains.objcdiff.errors

import java.io.File

internal fun throwParametersIssueError(actualFile: File, expectedFile: File): Nothing {
    val actualExist = actualFile.exists()
    val expectedExist = expectedFile.exists()

    val errorMessage = buildString {
        append("\nArguments error")
        if (!actualExist) {
            append("\n")
            append("Actual file `$actualFile` does not exist.")
        }

        if (!expectedExist) {
            append("\n")
            append("Expected file `$expectedFile` does not exist.")
        }
    }

    error(errorMessage)
}