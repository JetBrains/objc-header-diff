package org.jetbrains.objcdiff

data class ObjCParameter(
    val name: String,
    val type: ObjCType,
    val swiftName: String? = null,
)

fun ObjCParameter.swiftNameOrName() = swiftName ?: name