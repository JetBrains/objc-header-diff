package org.jetbrains.objcdiff

class DiffContext(
    val skipRefType: Boolean = false
) {
    private val cache = mutableMapOf<String, ObjCType>()

    fun buildLambdaType(returnType: ObjCType, arguments: List<ObjCType> = emptyList()): ObjCType.LambdaType {
        return makeOrCache(ObjCType.LambdaType(returnType, arguments))
    }

    fun buildPrimitiveType(name: String): ObjCType.PrimitiveType {
        return makeOrCache(ObjCType.PrimitiveType(name))
    }

    fun buildObjectType(
        name: String,
        generics: List<ObjCType> = emptyList(),
        members: List<ObjCMember> = emptyList(),
        nullable: Boolean = false,
        superType: ObjCType? = null,
        classifierType: ClassifierType = ClassifierType.Undefined,
    ): ObjCType.ObjectType {
        return makeOrCache(ObjCType.ObjectType(name, generics, members, superType, nullable, classifierType))
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T : ObjCType> makeOrCache(type: T): T {
        val cachedType = cache[type.key]
        val freshType = if (cachedType != null) {
            pickFresh(cachedType, type)
        } else type
        cache[type.key] = freshType
        return freshType as T
    }

    private fun pickFresh(a: ObjCType, b: ObjCType): ObjCType {
        return if (a is ObjCType.ObjectType && b is ObjCType.ObjectType) {
            if (a.superType != null && b.superType == null) {
                a
            } else b
        } else a
    }
}