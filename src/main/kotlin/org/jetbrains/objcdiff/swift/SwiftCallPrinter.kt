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

                // Handle default values based on type
                when (argType.source.name) {
                    "BOOL" -> sb.append("true")
                    else -> error("unsupported type '${argType.source.name}'")
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
