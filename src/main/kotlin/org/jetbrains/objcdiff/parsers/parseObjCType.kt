package org.jetbrains.objcdiff.parsers

import org.jetbrains.objcdiff.ClassifierType
import org.jetbrains.objcdiff.DiffContext
import org.jetbrains.objcdiff.ObjCType

context(DiffContext)
fun String.parseObjCType(classifierType: ClassifierType = ClassifierType.Undefined): ObjCType {
    return foldTokensToType(parseObjCTokens(this), classifierType).first()
}

context(DiffContext)
fun foldTokensToType(
    tokens: List<ObjCToken>,
    classOrInterface: ClassifierType = ClassifierType.Undefined
): List<ObjCType> {
    if (tokens.isEmpty()) return emptyList()

    return tokens.filterPrimaryTokens().map { token ->
        if (token is ObjCToken.PrimitiveType) {
            buildPrimitiveType(token.value)
        } else if (token is ObjCToken.LambdaType) {
            buildLambdaType(
                foldTokensToType(
                    listOf(token.returnType)
                ).first(),
                foldTokensToType(token.arguments)
            )
        } else {
            var nullable = false
            val generics = if (token is ObjCToken.IdType) {
                nullable = token.nullable
                foldTokensToType(token.tokens, classOrInterface)
            } else if (token is ObjCToken.ObjectType) {
                nullable = token.nullable
                foldTokensToType(token.tokens, classOrInterface)
            } else emptyList()

            buildObjectType(token.value, generics, emptyList(), nullable, null)
        }
    }
}

fun List<ObjCToken>.filterPrimaryTokens(): List<ObjCToken> {
    return filter {
        it is ObjCToken.PrimitiveType
                || it is ObjCToken.ObjectType
                || it is ObjCToken.Instance
                || it is ObjCToken.IdType
                || it is ObjCToken.Void
                || it is ObjCToken.LambdaType
    }
}