package org.example

import org.example.org.jetbrains.objcdiff.DiffContext
import org.example.org.jetbrains.objcdiff.reports.buildReport

fun main() {
    with(DiffContext(skipRefType = true)) {
        buildReport()
    }
}