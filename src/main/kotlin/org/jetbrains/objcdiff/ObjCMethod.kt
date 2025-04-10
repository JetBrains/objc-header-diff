package org.jetbrains.objcdiff

data class ObjCMethod(
    val name: String,
    val returnType: ObjCType?,
    val parameters: List<ObjCParameter> = emptyList()
) : ObjCMember() {
    override val key: String
        get() = name + ":" + returnType?.key + " " + parameters.joinToString(", ") { it.name + ":" + it.type.key }
}