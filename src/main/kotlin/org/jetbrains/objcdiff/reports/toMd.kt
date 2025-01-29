package org.jetbrains.objcdiff.reports

import org.jetbrains.objcdiff.DiffContext

context(DiffContext)
fun HeaderReport.toMd(): String {
    val sb = StringBuilder()
    sb.appendLine("# Header `$fileName`")
    sb.appendLine("Protocols(${protocols.size}): " + protocols.map { it.name }.joinToStringFormattedOrEmpty())
        .newMdLine()
    sb.appendLine("Interfaces(${interfaces.size}): " + interfaces.map { it.name }.joinToStringFormattedOrEmpty())
    sb.appendLine("## Graph")
    sb.appendLine((protocols + interfaces).toClassDiagramMermaid())
    return sb.toString()
}

context(DiffContext)
fun DiffReport.toMd(): String {
    val sb = StringBuilder()
    sb.appendLine("# Diff")
    sb.appendLine("Expected, but not defined(${expectedButNotDefined.size}): ${expectedButNotDefined.joinToStringFormattedOrEmpty()}")
        .newMdLine()
    sb.appendLine("Defined, but not expected(${definedButNotExpected.size}): ${definedButNotExpected.joinToStringFormattedOrEmpty()}")
        .newMdLine()
    sb.appendLine("Unequal members(${unequalMembers.size}): `${unequalMembers.joinToString(", ")}`")
    sb.appendLine((merge).toClassDiagramMermaid())

    return sb.toString()
}

private fun Collection<String>.joinToStringFormattedOrEmpty(): String {
    return if (isEmpty()) ""
    else joinToString(
        separator = ", ",
        prefix = "`",
        postfix = "`"
    )
}

private fun StringBuilder.newMdLine() {
    append("<br />")
}