package org.jetbrains.objcdiff.swift

import org.jetbrains.objcdiff.ObjCMethod
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

