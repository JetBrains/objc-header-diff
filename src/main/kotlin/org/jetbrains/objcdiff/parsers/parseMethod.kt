package org.jetbrains.objcdiff.parsers

import org.jetbrains.objcdiff.*

context(DiffContext)
fun String.parseMethod(container: ObjCType? = null): ObjCMethod? {
    if (this.startsWith("@property")) return null

    var static = false
    var returnType: ObjCType? = null
    val methodName: String
    val raw = this.substringBefore("__attribute__").trim() //attributes are always in the end, we don't need them

    val rawSelectors = raw.consumePrefix("""[+-] """) { prefix ->
        static = prefix?.startsWith("+") ?: error("Invalid method prefix `$prefix`")
    }.consumePrefix("""\((.*?)\)""") { prefix ->
        returnType = prefix.dropBracketsOrError().parseObjCType()
    }

    val selectors = splitSelectors(rawSelectors)

    methodName = selectors.first().prefix

    val parameters = selectors.filter { it.type.isNotEmpty() }.map {
        val name = it.postfix
        val type = it.type.parseObjCType()
        ObjCParameter(name, type)
    }

    val isConstructor = returnType?.name == "instancetype"

    return ObjCMethod(
        name = methodName,
        returnType = returnType,
        parameters = parameters,
        isStatic = static,
        isConstructor = isConstructor,
        container = container,
        source = this
    )
}