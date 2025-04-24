package org.jetbrains.objcdiff

import org.jetbrains.objcdiff.parsers.*
import org.jetbrains.objcdiff.parsers.ObjCToken.*
import org.jetbrains.objcdiff.parsers.ObjCToken.ObjectType
import kotlin.test.Test
import kotlin.test.assertEquals

class ObjCTokenParserTest {
    @Test
    fun `test - primitive`() {
        assertEquals(
            listOf(PrimitiveType("float")),
            parseObjCTokens("float")
        )
    }

    @Test
    fun `test - id`() {
        assertEquals(
            listOf(IdType()),
            parseObjCTokens("id")
        )
    }

    @Test
    fun `test - nullable primitive`() {
        val actual = parseObjCTokens("float _Nullable")
        assertEquals(
            listOf(PrimitiveType(name = "float", nullable = true)),
            actual
        )
    }

    @Test
    fun `test - instance`() {
        val actual = parseObjCTokens("instancetype")
        assertEquals(
            listOf(Instance),
            actual
        )
    }

    @Test
    fun `test - primitive pointer`() {
        assertEquals(
            listOf(PrimitiveType("int")),
            parseObjCTokens("int *")
        )
    }

    @Test
    fun `test - nullable generic`() {
        assertEquals(
            listOf(ObjectType(name = "T", tokens = emptyList(), nullable = true)),
            parseObjCTokens("T _Nullable")
        )
    }

    @Test
    fun `test - struct NSZone pointer`() {
        assertEquals(
            listOf(ObjectType("_NSZone")),
            parseObjCTokens("struct _NSZone *")
        )
    }

    @Test
    fun `test - basic generic`() {
        val actual = parseObjCTokens("id<KotlinIterator>")
        assertEquals(
            listOf(IdType(ObjectType("KotlinIterator"))),
            actual
        )
    }

    @Test
    fun `test - nested generic`() {
        val actual = parseObjCTokens("id<KotlinIterator<String>>")
        assertEquals(
            listOf(IdType(ObjectType("KotlinIterator", PrimitiveType("String")))),
            actual
        )
    }

    @Test
    fun `test - basic functional type`() {
        val actual = parseObjCTokens("Int (^)(String)")
        assertEquals(
            listOf(LambdaType(PrimitiveType("Int"), listOf(PrimitiveType("String")))),
            actual
        )
    }

    @Test
    fun `test - nullable fold`() {
        val actual = parseObjCTokens("void (^)(NSError * _Nullable)")
        assertEquals(
            listOf(
                LambdaType(
                    Void,
                    listOf(ObjectType("NSError", nullable = true))
                )
            ),
            actual
        )
    }

    @Test
    fun `test - multiple return type`() {
        val actual = parseObjCTokens("NSArray<id _Nullable (^)(id _Nullable, id _Nullable)> *")
        assertEquals(
            listOf(
                ObjectType("NSArray", listOf(
                    LambdaType(IdType(true), listOf(IdType(true), IdType(true))),
                ))
            ),
            actual
        )
    }

    @Test
    fun `lambda returns id and takes two id arguments`() {
        val actual = parseObjCTokens("id _Nullable (^)(id _Nullable, id)")
        assertEquals(
            listOf(
                LambdaType(
                    IdType(true),
                    listOf(
                        IdType(true),
                        IdType(false),
                    )
                )
            ),
            actual
        )
    }
}