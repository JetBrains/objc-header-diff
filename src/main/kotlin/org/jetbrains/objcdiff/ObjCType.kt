package org.example.org.jetbrains.objcdiff

data class ObjCType(
    val name: String,
    val generics: List<ObjCType> = emptyList(),
    val nullable: Boolean = false
) : Diffable() {
    override val key: String
        get() {
            return name
        }
}