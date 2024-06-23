package org.example.org.jetbrains.objcdiff.reports

import org.example.org.jetbrains.objcdiff.DiffContext
import org.example.org.jetbrains.objcdiff.utils.storeFile

/**
 * Parses headers and generates 4 files:
 * - `diff.md` with headers diff
 * - `diff.json` simplified diff report
 * - `actual.h.md` info and classes graph of `actual.h`
 * - `expected.h.md` info and classes graph of `expected.h`
 */
context(DiffContext)
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

