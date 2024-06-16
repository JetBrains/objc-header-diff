package org.example.org.jetbrains.objcdiff.reports

fun DiffReport.toJson(): String {
    val sb = StringBuilder()

    sb.append("{\n")
    sb.appendLine(" \"date\": \"$date\",")
    sb.appendLine(" \"definedButNotExpected\": $definedButNotExpected,")
    sb.appendLine(" \"expectedButNotDefined\": $expectedButNotDefined,")
    sb.appendLine(" \"unequalMembers\": $unequalMembers")
    sb.appendLine("}")

    return sb.toString()
}