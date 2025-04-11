package org.jetbrains.objcdiff

data class ObjCProperty(
    val name: String, val type: ObjCType, val nullable: Boolean,
    val container: ObjCType?,
    override val source: String
) : ObjCMember(source) {
    override val key: String
        get() = name + ":" + type.key + " ?:" + nullable
}