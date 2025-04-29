package org.jetbrains.objcdiff.parsers

fun String.getMethodSwiftAttribute(): String {
    val swiftNamePattern = """__attribute__\(\(swift_name\("([^"]*)"\)\)\)""".toRegex()
    val matchResult = swiftNamePattern.find(this)
    return matchResult?.groupValues?.get(1) ?: ""
}


fun String.getMethodSwiftName(): String {
    val indexOfParenthesis = indexOf('(')
    return if (indexOfParenthesis != -1) {
        substring(0, indexOfParenthesis)
    } else {
        this
    }
}

fun String.getMethodSwiftArguments(): List<String> {
    val parameterPattern = """\((.*?)\)""".toRegex()
    val matchResult = parameterPattern.find(this)
    val parametersString = matchResult?.groupValues?.get(1) ?: return emptyList()

    if (parametersString.isEmpty()) return emptyList()

    return parametersString
        .split(":")
        .filter { it.isNotEmpty() }
        .map { it.trim() }
}

fun parseParameterNames(swiftNameValue: String): List<String> {
    val functionPattern = Regex("""\w+\((.*?)\)""")
    val match = functionPattern.matchEntire(swiftNameValue.trim())

    return when {
        match != null -> {
            val params = match.groupValues[1]
            if (params.isBlank()) {
                emptyList()
            } else {
                params.split(':')
                    .map { it.trim().removeSuffix(":") }
                    .filter { it.isNotEmpty() }
            }
        }
        else -> {
            if (swiftNameValue.isBlank()) {
                emptyList()
            } else {
                listOf(swiftNameValue.trim())
            }
        }
    }
}