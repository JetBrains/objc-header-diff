package org.jetbrains.objcdiff.swift

import org.jetbrains.objcdiff.ObjCMethod
import org.jetbrains.objcdiff.parsers.getMethodSwiftArguments
import org.jetbrains.objcdiff.parsers.getMethodSwiftAttribute
import org.jetbrains.objcdiff.parsers.getMethodSwiftName

fun ObjCMethod.asSwiftMethod(): SwiftFunction {
    val attr = source.getMethodSwiftAttribute()
    val name = attr.getMethodSwiftName()
    val argumentNames = attr.getMethodSwiftArguments()

    val arguments = LinkedHashMap<String, SwiftType>()

    argumentNames.forEachIndexed { index, swiftArgumentName ->
        val type = this.arguments[index]
        val typeName = type.type.name
        arguments[swiftArgumentName] = SwiftType(typeName, type.type)
    }

    return SwiftFunction(
        name, isStatic, isConstructor, arguments, container.asSwiftType()
    )
}
