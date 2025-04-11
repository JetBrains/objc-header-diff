package org.jetbrains.objcdiff.swift

import org.jetbrains.objcdiff.ObjCMethod
import org.jetbrains.objcdiff.asSwiftType
import org.jetbrains.objcdiff.parsers.getMethodSwiftArguments
import org.jetbrains.objcdiff.parsers.getMethodSwiftAttribute
import org.jetbrains.objcdiff.parsers.getMethodSwiftName

data class SwiftFunction(
    val name: String,
    val isStatic: Boolean,
    val isConstructor: Boolean,
    val arguments: Map<String, SwiftType>,
    val container: SwiftType? = null,
)

fun ObjCMethod.asSwiftMethod(): SwiftFunction {
    val attr = source.getMethodSwiftAttribute()
    val name = attr.getMethodSwiftName()
    val argumentNames = attr.getMethodSwiftArguments()

    val arguments = LinkedHashMap<String, SwiftType>()

    argumentNames.forEachIndexed { index, swiftArgumentName ->
        val type = parameters[index]
        val typeName = type.type.name
        arguments[swiftArgumentName] = SwiftType(typeName, type.type)
    }

    return SwiftFunction(
        name, isStatic, isConstructor, arguments, container.asSwiftType()
    )
}
