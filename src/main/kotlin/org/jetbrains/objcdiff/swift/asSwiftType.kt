package org.jetbrains.objcdiff.swift

import org.jetbrains.objcdiff.ObjCType

@JvmName("asNullableSwiftType")
fun ObjCType?.asSwiftType(): SwiftType? {
    if (this == null) return null
    return SwiftType(name, this)
}

fun ObjCType.asSwiftType(): SwiftType {
    return SwiftType(name, this)
}