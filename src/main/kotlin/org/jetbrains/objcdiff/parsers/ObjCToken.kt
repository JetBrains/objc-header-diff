package org.jetbrains.objcdiff.parsers

import org.jetbrains.objcdiff.parsers.ObjCToken.NonPrimitiveType
import org.jetbrains.objcdiff.primitives

sealed class ObjCToken(val value: String = "") {
    data class PrimitiveType(val name: String) : ObjCToken(name)
    data object Nullable : ObjCToken("_Nullable")
    data object Struct : ObjCToken("struct")
    data object Pointer : ObjCToken("*")
    data object Instance : ObjCToken("instancetype")
    data object Void : ObjCToken("void")
    data class FunctionType(
        val returnType: List<ObjCToken>,
        val arguments: List<ObjCToken>
    ) : ObjCToken("")

    data class Id(val tokens: List<ObjCToken>) : ObjCToken("id") {
        constructor(token: ObjCToken) : this(listOf(token))
        constructor() : this(emptyList())
    }

    data class NonPrimitiveType(val name: String, val tokens: List<ObjCToken>) : ObjCToken(name) {
        constructor(name: String, token: ObjCToken) : this(name, listOf(token))
        constructor(name: String) : this(name, emptyList())
    }
}

fun parseType(source: String): List<ObjCToken> {
    return TypeParser(source).parse()
}

class TypeParser(val source: String) {

    fun parse(): List<ObjCToken> {
        val groupTokens = parseGroupToken(source)
        return groupTokens.map { unfold(it) }.flatten()
    }

    private fun unfold(group: GroupToken): List<ObjCToken> {
        val result = mutableListOf<ObjCToken>()
        val source = group.name
        var pointer = 0
        var typeConsumed = false

        consume(ObjCToken.Nullable, source, pointer) { token, size ->
            pointer += size
            result.add(token)
        }

        consume(ObjCToken.Instance, source, pointer) { token, size ->
            pointer += size
            result.add(token)
            typeConsumed = true
        }

        consume(ObjCToken.Void, source, pointer) { token, size ->
            pointer += size
            result.add(token)
            typeConsumed = true
        }

        consume(ObjCToken.Struct, source, pointer) { token, size ->
            pointer += size
            result.add(token)
        }

        consume(ObjCToken.Pointer, source, pointer) { token, size ->
            pointer += size
            result.add(token)
        }

        consumeId(source, pointer) { _, size ->
            pointer += size
            val childrenTokens = group.children.map { child -> unfold(child) }.flatten()
            result.add(ObjCToken.Id(childrenTokens))
            typeConsumed = true
        }

        if (!typeConsumed) {
            consumePrimitiveType(source) { token, size ->
                pointer += size
                result.add(token)
                typeConsumed = true
            }
        }

        if (!typeConsumed) {
            consumeNonPrimitiveType(source, pointer) { token, size ->
                pointer += size
                val childrenTokens = group.children.map { child -> unfold(child) }.flatten()
                result.add(NonPrimitiveType(token.name, childrenTokens))
                typeConsumed = true

            }
        }

        return result
    }
}

private fun consumeId(source: String, pointer: Int, onResult: (ObjCToken.Id, Int) -> Unit) {
    if (source.startsWith("id", pointer)) {

        if (source.isOutOfRange(pointer + 2)) {
            consume(ObjCToken.Id(), source, pointer) { token, size ->
                onResult(token, size)
            }
        }
    }
}

private fun consumeNonPrimitiveType(source: String, pointer: Int, onResult: (NonPrimitiveType, Int) -> Unit) {
    if (source.isOutOfRange(pointer)) return
    consumeUntilOrEnd(' ', source, pointer) { name, _ ->
        onResult(NonPrimitiveType(name), name.length + 1)
    }
}

private fun consumePrimitiveType(source: String, onResult: (ObjCToken, Int) -> Unit) {
    primitives.forEach { primitive ->
        if (source.startsWith(primitive)) {
            onResult(ObjCToken.PrimitiveType(primitive), primitive.length + 1)
            return@consumePrimitiveType
        }
    }
}

fun <T : ObjCToken> consume(token: T, source: String, pointer: Int, onResult: (T, Int) -> Unit) {
    val value = token.value
    if (source.startsWith(value, pointer)) onResult(token, value.length + 1)
}