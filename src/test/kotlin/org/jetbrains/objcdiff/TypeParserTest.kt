package org.jetbrains.objcdiff

import org.jetbrains.objcdiff.parsers.ObjCToken.*
import org.jetbrains.objcdiff.parsers.TypeParser
import org.jetbrains.objcdiff.parsers.parseType
import org.junit.jupiter.api.Disabled
import kotlin.test.Test
import kotlin.test.assertEquals

class TypeParserTest {
    @Test
    fun `test - primitive`() {
        assertEquals(
            listOf(PrimitiveType("float")),
            TypeParser("float").parse()
        )
    }

    @Test
    fun `test - id`() {
        assertEquals(
            listOf(Id()),
            TypeParser("id").parse()
        )
    }

    @Test
    fun `test - nullable primitive`() {
        assertEquals(
            listOf(PrimitiveType("float"), Nullable),
            TypeParser("float _Nullable").parse()
        )
    }

    @Test
    fun `test - instance`() {
        assertEquals(
            listOf(Instance),
            TypeParser("instancetype").parse()
        )
    }

    @Test
    fun `test - primitive pointer`() {
        assertEquals(
            listOf(PrimitiveType("int"), Pointer),
            parseType("int *")
        )
    }

    @Test
    fun `test - nullable generic`() {
        assertEquals(
            listOf(NonPrimitiveType("T"), Nullable),
            parseType("T _Nullable")
        )
    }

    @Test
    fun `test - struct NSZone pointer`() {
        assertEquals(
            listOf(Struct, NonPrimitiveType("_NSZone"), Pointer),
            parseType("struct _NSZone *")
        )
    }

    @Test
    fun `test - basic generic`() {
        val actual = parseType("id<KotlinIterator>")
        assertEquals(
            listOf(Id(NonPrimitiveType("KotlinIterator"))),
            actual
        )
    }

    @Test
    fun `test - nested generic`() {
        val actual = parseType("id<KotlinIterator<String>>")
        assertEquals(
            listOf(Id(NonPrimitiveType("KotlinIterator", PrimitiveType("String")))),
            actual
        )
    }

    @Test
    @Disabled
    fun `test - basic functional type`() {
        parseType("Int (^)(String)")
    }

    @Test
    @Disabled
    fun `test - nullable fold`() {
        parseType("void (^)(NSError * _Nullable)")
    }

    @Test
    @Disabled
    fun `test - multiple return type`() {
        parseType("NSArray<id _Nullable (^)(id _Nullable, id _Nullable)> *")
    }

    @Test
    @Disabled
    fun `test - pointer fold`() {
        parseType("void (^)(KtInt * _Nullable, NSError * _Nullable)")
    }
}