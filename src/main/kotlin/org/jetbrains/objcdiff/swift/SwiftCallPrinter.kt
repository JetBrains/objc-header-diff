package org.jetbrains.objcdiff.swift

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

fun createPrimitiveValue(type: SwiftType): String {
    return when (type.name) {
        "BOOL" -> "true"
        "NSString" -> "\"\""
        else -> error("unsupported type '${type.name}'")
    }
}