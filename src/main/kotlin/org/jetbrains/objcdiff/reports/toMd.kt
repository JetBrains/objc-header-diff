package org.example.org.jetbrains.objcdiff.reports

import org.example.org.jetbrains.objcdiff.DiffContext

context(DiffContext)
fun HeaderReport.toMd(): String {
    val sb = StringBuilder()
    sb.appendLine("# Header `$fileName`\n")
    sb.appendLine("Protocols(${protocols.size}): " + protocols.joinToString(", ") { it.name } + "\n")
    sb.appendLine("Interfaces(${interfaces.size}): " + interfaces.joinToString(", ") { it.name } + "\n")
    sb.appendLine("# Graph")
    sb.appendLine((protocols + interfaces).toClassDiagramMermaid())
    return sb.toString()
}

context(DiffContext)
fun DiffReport.toMd(): String {
    val sb = StringBuilder()
    sb.appendLine("# Diff")
    sb.appendLine("Expected, but not defined count: `$expectedButNotDefined`").newMdLine()
    sb.appendLine("Defined, but not expected count: `$definedButNotExpected`").newMdLine()
    sb.appendLine("Unequal members count: `$unequalMembers`")
    sb.appendLine((merge).toClassDiagramMermaid())

    return sb.toString()
}

private fun StringBuilder.newMdLine() {
    append("<br />")
}