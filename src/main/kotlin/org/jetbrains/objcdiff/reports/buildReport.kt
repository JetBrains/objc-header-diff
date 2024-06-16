package org.example.org.jetbrains.objcdiff.reports

import org.example.org.jetbrains.objcdiff.utils.storeFile

/**
 * Result report consists of 3 files
 */
fun buildReport() {
    val actualFileName = "actual.h"
    val expectedFileName = "expected.h"

    val actualReport = buildHeaderReport(actualFileName)
    storeFile("$actualFileName.md", actualReport.toMd())

    val expectedReport = buildHeaderReport(expectedFileName)
    storeFile("$expectedFileName.md", expectedReport.toMd())

    val diffReport = buildDiffReport(expectedReport, actualReport)
    storeFile("diff.md", diffReport.toMd())
    storeFile("diff.json", diffReport.toJson())
}