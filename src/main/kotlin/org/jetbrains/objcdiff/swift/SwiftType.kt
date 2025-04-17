package org.jetbrains.objcdiff.swift

import org.jetbrains.objcdiff.ObjCType

data class SwiftType(
    val name: String,
    val source: ObjCType,
) {
    val isPrimitive: Boolean = source.isPrimitive
}
