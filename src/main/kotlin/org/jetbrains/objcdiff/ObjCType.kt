package org.jetbrains.objcdiff

data class ObjCType(
    override val key: String,

    val name: String,
    val generics: List<ObjCType> = emptyList(),
    val nullable: Boolean = false,

    val classOrInterface: String, //interface or class
    val members: List<ObjCMember>,
    val superType: ObjCType? = null
) : Diffable()