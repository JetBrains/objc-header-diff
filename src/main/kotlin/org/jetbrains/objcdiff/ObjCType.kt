package org.jetbrains.objcdiff

import org.jetbrains.objcdiff.swift.SwiftType

sealed class ObjCType(
    open val name: String = ""
) : Diffable() {

    data class PrimitiveType(
        override val name: String
    ) : ObjCType()

    data class ObjectType(
        override val name: String,
        val generics: List<ObjCType> = emptyList(),
        val members: List<ObjCMember> = emptyList(),
        val superType: ObjCType? = null,
        val nullable: Boolean = false,
        val type: ClassifierType = ClassifierType.Undefined,
        val swiftName: String? = null
    ) : ObjCType()

    data class LambdaType(
        val returnType: ObjCType,
        val arguments: List<ObjCType>
    ) : ObjCType() {
        override val key: String
            get() = returnType.key + " " + arguments.joinToString(", ") { it.key }
    }

    override val key: String
        get() = name

    val isPrimitive: Boolean
        get() = primitives.contains(name)
}

fun ObjCType.getSuperTypeOrNull(): ObjCType? {
    return when (this) {
        is ObjCType.ObjectType -> superType
        else -> null
    }
}

fun ObjCType.getGenericsOrNull(): List<ObjCType>? {
    return when (this) {
        is ObjCType.ObjectType -> generics
        else -> null
    }
}

val primitives = setOf(
    "Int", "String",
    // Basic C types
    "BOOL", "char", "short", "int", "long", "float", "double",
    // Foundation types
    "NSString", "NSInteger", "NSUInteger", "CGFloat",
    // Objective-C runtime types
    "Class", "SEL", "IMP",
    // Fixed-width integer types
    "int8_t", "uint8_t", "int16_t", "uint16_t", "int32_t", "uint32_t", "int64_t", "uint64_t"
)

enum class ClassifierType {
    Protocol, Interface,
    Undefined // for the cases when it's types comes from dependency
}