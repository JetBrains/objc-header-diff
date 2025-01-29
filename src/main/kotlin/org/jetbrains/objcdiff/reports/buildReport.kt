package org.jetbrains.objcdiff.reports

import org.jetbrains.objcdiff.DiffContext
import org.jetbrains.objcdiff.utils.storeFile
import org.jetbrains.objcdiff.reports.buildDiffReport
import java.io.File

/**
 * Parses headers and generates 4 files:
 * - `diff.md` with headers diff
 * - `diff.json` simplified diff report
 * - `actual.h.md` info and classes graph of `actual.h`
 * - `expected.h.md` info and classes graph of `expected.h`
 */
context(DiffContext)
fun buildReport(actual: File, expected: File) {

    val actualReport = buildHeaderReport(actual)
    storeFile("${actual.name}.md", actualReport.toMd())

    val expectedReport = buildHeaderReport(expected)
    storeFile("${expected.name}.md", expectedReport.toMd())

    val diffReport = buildDiffReport(expectedReport, actualReport)
    storeFile("diff.md", diffReport.toMd())
    storeFile("diff.json", diffReport.toJson())
}

