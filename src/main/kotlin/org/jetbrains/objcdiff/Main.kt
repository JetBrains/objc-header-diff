package org.jetbrains.objcdiff

import org.jetbrains.objcdiff.errors.throwInvalidParametersIssueError
import org.jetbrains.objcdiff.errors.throwParametersIssueError
import org.jetbrains.objcdiff.reports.buildReport
import java.io.File

fun main(args: Array<String>) {
    with(ObjCContext(skipRefType = true)) {

        val (actual, expected) = when {
            args.isEmpty() -> defaultActual to defaultExpected
            args.size == 2 -> {
                val actualFile = File(args[0])
                val expectedFile = File(args[1])
                if (!actualFile.exists() || !expectedFile.exists()) throwParametersIssueError(actualFile, expectedFile)
                else actualFile to expectedFile
            }

            else -> {
                throwInvalidParametersIssueError(args.size)
            }
        }

        buildReport(actual, expected)
    }
}

val defaultActual = File("build/resources/main/actual.h")
val defaultExpected = File("build/resources/main/expected.h")
