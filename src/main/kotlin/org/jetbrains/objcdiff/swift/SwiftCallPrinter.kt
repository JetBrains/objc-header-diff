package org.jetbrains.objcdiff.swift

import org.jetbrains.objcdiff.ObjCMethod
import org.jetbrains.objcdiff.ObjCType.ObjectType

class SwiftCallPrinter {

    private val sb = StringBuilder()

    fun add(function: SwiftFunction): SwiftCallPrinter {
        sb.append(function.name)
        sb.append("(")

        val args = function.arguments
        if (args.isNotEmpty()) {
            args.entries.forEachIndexed { index, (argName, argType) ->
                if (index > 0) sb.append(", ")
                sb.append("$argName: ")

                if (argType.isPrimitive) {
                    sb.append(createPrimitiveValue(argType))
                }
            }
        }

        sb.append(")")
        return this
    }

    fun print(): String {
        return sb.toString()
    }
}

fun makeSwiftCall(obj: ObjectType): String {
    val sb = StringBuilder()
    val name = obj.name
    val constructors = obj.getConstructors()

    if (constructors.isEmpty()) return ""

    constructors.forEachIndexed { index, c ->
        sb.append("let a${index} = ${name}()")
    }

    return sb.toString()
}

fun ObjectType.getConstructors(): List<ObjCMethod> {
    return members.filterIsInstance<ObjCMethod>().filter { it.returnType?.name == "instancetype" }
}

fun createPrimitiveValue(type: SwiftType): String {
    return when (type.name) {
        "BOOL" -> "true"
        "NSString" -> "\"\""
        else -> error("unsupported type '${type.name}'")
    }
}