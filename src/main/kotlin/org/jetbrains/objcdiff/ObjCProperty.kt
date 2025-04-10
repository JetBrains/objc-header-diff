package org.jetbrains.objcdiff

data class ObjCProperty(
    val name: String,
    val type: ObjCType,
    val nullable: Boolean = false
) : ObjCMember() {
    override val key: String
        get() = name + ":" + type.key + " ?:" + nullable
}