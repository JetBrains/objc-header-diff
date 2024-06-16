package org.example.org.jetbrains.objcdiff

data class ObjCClassOrInterface(
    override val key: String,
    val type: ObjCType,
    val classOrInterface: String, //interface or class
    val members: List<ObjCMember>,
    val superType: ObjCType? = null
) : Diffable()