package org.jetbrains.objcdiff

import org.jetbrains.objcdiff.swift.SwiftType

data class ObjCType(
    val name: String,
    val generics: List<ObjCType> = emptyList(),
    val nullable: Boolean = false,
    val classifierType: ClassifierType = ClassifierType.Undefined,
    val members: List<ObjCMember> = emptyList(),
    val superType: ObjCType? = null
) : Diffable() {

    override val key: String
        get() = name
    val isPrimitive: Boolean
        get() = primitives.contains(name)
}

val primitives = setOf(
    // Basic C types
    "BOOL", "char", "short", "int", "long", "float", "double",
    // Foundation types
    "NSString", "NSInteger", "NSUInteger", "CGFloat",
    // Objective-C runtime types
    "id", "Class", "SEL", "IMP",
    // Fixed-width integer types
    "int8_t", "uint8_t", "int16_t", "uint16_t", "int32_t", "uint32_t", "int64_t", "uint64_t"
)

enum class ClassifierType {
    Protocol, Interface,
    Undefined // for the cases when it's types comes from dependency
}

fun ObjCType?.asSwiftType(): SwiftType? {
    if (this == null) return null
    return SwiftType(name, this)
}