package org.example.org.jetbrains.objcdiff.reports

val ignoredTypes = setOf(
    "id",
    "void",
    "instancetype",
    "NSArray",
    "NSString",
    "BOOL",
    "int32_t",
    "int8_t",
    "int16_t",
    "int64_t",
    "T",
    "Int",
    "NSUInteger",
    "Byte",
    "NSSet",
    "unichar",
    "double",
    "float",
    "Base",
    "int"
)

val String.isIgnoredType: Boolean
    get() {
        return ignoredTypes.contains(this)
    }