package org.jetbrains.objcdiff

data class ObjCMethod(
    val name: String,
    val returnType: ObjCType?,
    val parameters: List<ObjCParameter> = emptyList()
) : ObjCMember()