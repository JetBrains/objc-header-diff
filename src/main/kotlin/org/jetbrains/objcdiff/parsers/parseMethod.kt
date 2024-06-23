package org.example.org.jetbrains.objcdiff.parsers

import org.example.org.jetbrains.objcdiff.DiffContext
import org.example.org.jetbrains.objcdiff.ObjCType
import org.example.org.jetbrains.objcdiff.ObjCMethod
import org.example.org.jetbrains.objcdiff.ObjCParameter

context(DiffContext)
fun String.parseMethod(): ObjCMethod? {
    if (this.startsWith("@property")) {
        return null
    }


    val raw = this.substringBefore("__attribute__").trim() //attributes are always in the end, we don't need them
    val nameAndReturnType = raw.substringBefore(':').extractTypeValuePairs()
    val parameters = raw.substringAfter(':').extractTypeValuePairs()


    if (nameAndReturnType.size != 1) {
        println("Error parsing name and return type from `$this`")
        return null
    }

    val returnType = nameAndReturnType.first().splitTypeValue()?.first?.parseType()
    val methodName = nameAndReturnType.first().splitTypeValue()?.second

    if (nameAndReturnType == parameters) {
        return ObjCMethod(
            name = methodName ?: "invalid_method_name",
            returnType = returnType
        )
    } else {


        return ObjCMethod(
            name = methodName ?: "invalid_method_name",
            returnType = returnType,
            parameters = parameters.map {
                val type = it.splitTypeValue()?.first?.parseType() ?: invalidParameterType
                val name = it.splitTypeValue()?.second ?: "invalid_parameter_name"
                ObjCParameter(name, type)
            }
        )
    }
}

private val invalidParameterType = ObjCType(
    key = "invalid_parameter_type",
    name = "invalid_parameter_type",
    generics = emptyList(),
    nullable = false,
    classOrInterface = "class",
    members = emptyList()
)

/**
 * "(int)size (string)name" -> ["(int)size", "(string)name"]
 *
 * Important: between type and name should not be a space.
 * Spaces allowed only between pairs, that is how they split among each other.
 */
fun String.extractTypeValuePairs(): List<String> {
    val regex = "\\(([^)]+)\\)([^\\s()]+)".toRegex()
    return regex.findAll(this).map { it.value }.toList()
}

/**
 * (int)size -> Pair("int", "size")
 */
fun String.splitTypeValue(): Pair<String, String>? {
    val regex = Regex("""\(([^)]+)\)(.+)""")
    val matchResult = regex.matchEntire(this)
    return if (matchResult != null && matchResult.groupValues.size == 3) {
        val (type, name) = matchResult.destructured
        type to name.replace(";", "")
    } else {
        return null
    }
}