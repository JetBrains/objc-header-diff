package org.jetbrains.objcdiff.parsers

import org.jetbrains.objcdiff.primitives
import org.jetbrains.objcdiff.utils.foldIndexedSkippable

sealed class ObjCToken(val value: String = "") {

    data object Covariant : ObjCToken("__covariant")
    data object Nullable : ObjCToken("_Nullable")
    data object Struct : ObjCToken("struct")
    data object Pointer : ObjCToken("*")
    data object LambdaReference : ObjCToken("^")
    data object Instance : ObjCToken("instancetype")
    data object Void : ObjCToken("void")

    data class PrimitiveType(val name: String, val nullable: Boolean = false) : ObjCToken(name)
    data class LambdaType(val returnType: ObjCToken, val arguments: List<ObjCToken>) : ObjCToken("")
    data class IdType(
        val tokens: List<ObjCToken> = emptyList(),
        val nullable: Boolean = false
    ) : ObjCToken("id")

    data class ObjectType(
        val name: String,
        val tokens: List<ObjCToken> = emptyList(),
        val nullable: Boolean = false
    ) : ObjCToken(name)
}

fun IdType(token: ObjCToken): ObjCToken.IdType = ObjCToken.IdType(listOf(token))
fun IdType(nullable: Boolean): ObjCToken.IdType = ObjCToken.IdType(emptyList(), nullable)
fun ObjectType(name: String, token: ObjCToken): ObjCToken.ObjectType = ObjCToken.ObjectType(name, listOf(token))
fun ObjectType(name: String): ObjCToken.ObjectType = ObjCToken.ObjectType(name, emptyList())

fun parseObjCTokens(source: String): List<ObjCToken> {
    return foldTokenNodes(parseTokenGraph(source).filterOutPointers())
}

private fun takeOrNull(token: ObjCToken): ObjCToken? {
    if (token is ObjCToken.Covariant) return null
    if (token is ObjCToken.Pointer) return null
    if (token is ObjCToken.Nullable) return null
    if (token is ObjCToken.Struct) return null
    return token
}

fun foldTokenNodes(rawTokens: List<ObjCTokenNode>): List<ObjCToken> {
    return rawTokens.foldIndexedSkippable(emptyList()) { index, acc, rawToken, skip ->
        var token = mapTokenNode(rawToken)
        val result = mutableListOf<ObjCToken>()

        if (token.isType()) {

            if (token is ObjCToken.ObjectType) {
                token = token.copy(tokens = foldTokenNodes(rawToken.children))
            } else if (token is ObjCToken.IdType) {
                token = token.copy(tokens = foldTokenNodes(rawToken.children))
            }

            var next = mapTokenOrNull(index.getNextOrNull())

            if (next is ObjCToken.Nullable) {

                if (token is ObjCToken.ObjectType) {
                    token = token.copy(nullable = true)
                } else if (token is ObjCToken.IdType) {
                    token = token.copy(nullable = true)
                } else if (token is ObjCToken.PrimitiveType) {
                    token = token.copy(nullable = true)
                } else {
                    error("Nullable token after unsupported type: $token")
                }

                skip(1)
                next = mapTokenOrNull(index.getNextOrNull())
            }

            if (next is ObjCToken.LambdaReference) {
                skip(1) // skip lambda reference
                val args = index.getNextOrNull()
                val lambdaArgs = if (args != null && args.name.isEmpty()) {
                    skip(1) // skip args
                    foldTokenNodes(args.children)
                } else emptyList()

                result.add(ObjCToken.LambdaType(token, lambdaArgs))
            } else {
                result.add(token)
            }
        }



        acc + result.mapNotNull { takeOrNull(it) }
    }
}

private fun mapTokenOrNull(group: ObjCTokenNode?): ObjCToken? {
    if (group == null) return null
    return mapTokenNode(group)
}

private fun mapTokenNode(node: ObjCTokenNode): ObjCToken {
    val source = node.name

    consume(ObjCToken.Nullable, source) { token ->
        return token
    }
    consume(ObjCToken.LambdaReference, source) { token ->
        return token
    }
    consume(ObjCToken.Instance, source) { token ->
        return token
    }
    consume(ObjCToken.Void, source) { token ->
        return token
    }
    consume(ObjCToken.Struct, source) { token ->
        return token
    }
    consume(ObjCToken.Covariant, source) { token ->
        return token
    }
    consume(ObjCToken.Pointer, source) { token ->
        return token
    }

    consumePrimitiveType(source) { token ->
        return token
    }

    consumeId(source) {
        return ObjCToken.IdType()
    }

    consumeClassifierType(source) { token ->
        return ObjCToken.ObjectType(token.name)
    }

    if (node.name.isEmpty() && node.children.size == 1 && node.children.first().name == "^") {
        return ObjCToken.LambdaReference
    }

    error("Unexpected node: $node")
}

private inline fun consumeId(source: String, onResult: () -> Unit) {
    if (source.startsWith("id")) {

        if (source.isOutOfRange(2)) {
            consume(ObjCToken.IdType(), source) {
                onResult()
            }
        }
    }
}

private inline fun consumeClassifierType(source: String, onResult: (ObjCToken.ObjectType) -> Unit) {
    if (source.isOutOfRange(0)) return
    consumeUntilOrEnd(' ', source, 0) { name, _ ->
        onResult(ObjectType(name))
    }
}

private inline fun consumePrimitiveType(source: String, onResult: (ObjCToken) -> Unit) {
    primitives.sortedBy {
        it.length * -1 // for handling startsWith overlapping cases: int64, int
    }.forEach { primitive ->
        if (source.startsWith(primitive)) {
            onResult(ObjCToken.PrimitiveType(primitive))
            return@consumePrimitiveType
        }
    }
}

private inline fun <T : ObjCToken> consume(token: T, source: String, onResult: (T) -> Unit) {
    val value = token.value
    if (source.startsWith(value)) onResult(token)
}

private fun ObjCToken.isType(): Boolean {
    return this is ObjCToken.ObjectType || this is ObjCToken.PrimitiveType || this is ObjCToken.Instance || this is ObjCToken.Void || this is ObjCToken.IdType
}

private fun List<ObjCTokenNode>.filterOutPointers(): List<ObjCTokenNode> {
    return mapNotNull {
        if (it.name == "*") null else it.copy(children = it.children.filterOutPointers())
    }
}