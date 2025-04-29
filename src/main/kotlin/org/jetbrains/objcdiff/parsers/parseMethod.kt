package org.jetbrains.objcdiff.parsers

import org.jetbrains.objcdiff.ObjCContext
import org.jetbrains.objcdiff.ObjCMethod
import org.jetbrains.objcdiff.ObjCParameter
import org.jetbrains.objcdiff.ObjCType

context(ObjCContext)
fun String.parseMethod(container: ObjCType? = null): ObjCMethod? {
    if (this.startsWith("@property")) return null

    var static = false
    var returnType: ObjCType? = null
    val methodName: String
    val swiftName = this.getMethodSwiftAttribute().dropLastBracketsWithContent()
    val raw = this.substringBefore("__attribute__").trim() //attributes are always in the end, we don't need them

    val rawSelectors = raw.consumePrefix("""[+-] """) { prefix ->
        static = prefix?.startsWith("+") ?: false//error("Invalid method prefix `$prefix`")
    }.consumePrefix("""\((.*?)\)""") { prefix ->
        returnType = prefix.dropBracketsOrError().parseObjCType()
    }

    val selectors = splitSelectors(rawSelectors)
    val swiftParameterNames = parseParameterNames(getMethodSwiftAttribute())

    methodName = selectors.first().prefix

    val parameters = selectors.filter { it.type.isNotEmpty() }.mapIndexed { index, it ->
        val name = it.postfix
        val type = it.type.parseObjCType()
        ObjCParameter(name, type, swiftParameterNames.getOrNull(index))
    }

    val isConstructor = returnType?.name == "instancetype"

    return ObjCMethod(
        name = methodName,
        returnType = returnType,
        arguments = parameters,
        isStatic = static,
        isConstructor = isConstructor,
        container = container,
        source = this,
        swiftName = swiftName,
    )
}