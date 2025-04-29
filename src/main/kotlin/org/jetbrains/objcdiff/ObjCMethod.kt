package org.jetbrains.objcdiff

data class ObjCMethod(
    val name: String,
    val returnType: ObjCType?,
    val arguments: List<ObjCParameter>,
    val isStatic: Boolean,
    val isConstructor: Boolean,
    val container: ObjCType?,
    override val source: String,
    val swiftName: String? = null,
) : ObjCMember(source) {
    override val key: String
        get() = name + ":" + returnType?.key + " " + arguments.joinToString(", ") { it.name + ":" + it.type.key }
}