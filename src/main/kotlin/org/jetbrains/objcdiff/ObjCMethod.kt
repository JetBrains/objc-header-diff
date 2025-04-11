package org.jetbrains.objcdiff

data class ObjCMethod(
    val name: String,
    val returnType: ObjCType?,
    val parameters: List<ObjCParameter>,
    val isStatic: Boolean,
    val isConstructor: Boolean,
    val container: ObjCType?,
    override val source: String
) : ObjCMember(source) {
    override val key: String
        get() = name + ":" + returnType?.key + " " + parameters.joinToString(", ") { it.name + ":" + it.type.key }
}