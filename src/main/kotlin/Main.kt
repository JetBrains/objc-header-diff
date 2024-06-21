package org.example

import org.example.org.jetbrains.objcdiff.reports.ReportGenContext
import org.example.org.jetbrains.objcdiff.reports.buildReport

fun main() {
    with(ReportGenContext(skipRefType = true)) {
        buildReport()
    }
}