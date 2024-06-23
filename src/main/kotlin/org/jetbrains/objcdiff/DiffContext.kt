package org.example.org.jetbrains.objcdiff

class DiffContext(
    val skipRefType: Boolean = false,
    val filterClass: String? = null
) {
    private val cache = mutableMapOf<String, ObjCType>()

    private fun makeOrCache(type: ObjCType): ObjCType {

        val cachedType = cache[type.key]
        val newType = if (cachedType != null) {
            println("decide what to pick between: ")
            println("cached: ${cache[type.key]}")
            println("new: $type")
            pickFull(cachedType, type)
        } else {
            type
        }
        return newType
    }

    fun buildType(
        key: String,
        name: String,
        classOrInterface: String, //interface or class
        generics: List<ObjCType> = emptyList(),
        nullable: Boolean = false,
        members: List<ObjCMember> = emptyList(),
        superType: ObjCType? = null
    ): ObjCType {
        return makeOrCache(
            ObjCType(
                key = key,
                name = name,
                generics = generics,
                nullable = nullable,
                classOrInterface = classOrInterface,
                members = members,
                superType = superType
            )
        )
    }

    private fun pickFull(a: ObjCType, b: ObjCType): ObjCType {
        return if (a.superType != null && b.superType == null) {
            a
        } else {
            b
        }
    }
}