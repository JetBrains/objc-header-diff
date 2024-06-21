package org.example.org.jetbrains.objcdiff.reports

context(ReportGenContext)
fun HeaderReport.toMd(): String {
    val sb = StringBuilder()
    sb.appendLine("# Header `$fileName`\n")
    sb.appendLine("Protocols(${protocols.size}): " + protocols.joinToString(", ") { it.type.name } + "\n")
    sb.appendLine("Interfaces(${interfaces.size}): " + interfaces.joinToString(", ") { it.type.name } + "\n")
    sb.appendLine("# Graph")
    sb.appendLine((protocols + interfaces).toClassDiagramMermaid())
    return sb.toString()
}

context(ReportGenContext)
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