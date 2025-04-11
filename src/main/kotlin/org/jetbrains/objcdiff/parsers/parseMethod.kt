package org.jetbrains.objcdiff.parsers

import org.jetbrains.objcdiff.*

context(DiffContext)
fun String.parseMethod(container: ObjCType? = null): ObjCMethod? {
    if (this.startsWith("@property")) {
        return null
    }


    val raw = this.substringBefore("__attribute__").trim() //attributes are always in the end, we don't need them
    val nameAndReturnType = raw.substringBefore(':').extractTypeValuePairs()
    val parameters = raw.substringAfter(':').extractTypeValuePairs()
    val static = this.startsWith("+")

    if (nameAndReturnType.size != 1) {
        println("Error parsing name and return type from `$this`")
        return null
    }

    val returnType = nameAndReturnType.first().splitTypeValue()?.first?.parseType()
    val methodName = nameAndReturnType.first().splitTypeValue()?.second
    val isConstructor = returnType?.name == "instancetype"

    if (nameAndReturnType == parameters) {
        return ObjCMethod(
            name = methodName ?: "invalid_method_name",
            returnType = returnType,
            parameters = emptyList(),
            isStatic = static,
            isConstructor = isConstructor,
            container = container,
            source = this
        )
    } else {


        return ObjCMethod(
            name = methodName ?: "invalid_method_name",
            returnType = returnType,
            parameters = parameters.map {
                val type = it.splitTypeValue()?.first?.parseType() ?: invalidParameterType
                val name = it.splitTypeValue()?.second ?: "invalid_parameter_name"
                ObjCParameter(name, type)
            },
            isStatic = static,
            isConstructor = isConstructor,
            container = container,
            source = this
        )
    }
}

private val invalidParameterType = ObjCType(
    name = "invalid_parameter_type",
    generics = emptyList(),
    nullable = false,
    classifierType = ClassifierType.Undefined,
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