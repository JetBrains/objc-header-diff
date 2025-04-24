package org.jetbrains.objcdiff

import org.jetbrains.objcdiff.parsers.ObjCTokenNode
import org.jetbrains.objcdiff.parsers.parseTokenGraph
import kotlin.test.Test
import kotlin.test.assertEquals

class TestParseObjCTokenGraph {

    @Test
    fun `test - empty`() {
        val result = parseTokenGraph("")
        assertEquals(emptyList(), result)
    }

    @Test
    fun `test - generic`() {
        val result = parseTokenGraph("T")
        assertEquals(listOf(ObjCTokenNode("T")), result)
    }

    @Test
    fun `test - nested generics`() {
        val result = parseTokenGraph("A<B>")
        assertEquals(listOf(ObjCTokenNode("A", ObjCTokenNode("B"))), result)
    }

    @Test
    fun `test - multiple nested generics`() {
        val result = parseTokenGraph("A<B<C>>>")
        assertEquals(
            listOf(ObjCTokenNode("A", ObjCTokenNode("B", ObjCTokenNode("C")))),
            result
        )
    }

    @Test
    fun `test - t nullable`() {
        val source = "T _Nullable"
        val actual = parseTokenGraph(source)

        assertEquals(listOf(ObjCTokenNode("T"), ObjCTokenNode("_Nullable")), actual)
    }

    @Test
    fun `test - T _Nullable (A)(B C)`() {
        val source = "T _Nullable (A)(B C)"
        val actual = parseTokenGraph(source)

        val expected = listOf(
            ObjCTokenNode("T"),
            ObjCTokenNode("_Nullable"),
            ObjCTokenNode("", ObjCTokenNode("A")),
            ObjCTokenNode("", listOf(ObjCTokenNode("B"), ObjCTokenNode("C")))
        )

        assertEquals(expected, actual)
    }

    @Test
    fun `test - (A)(B)`() {
        val source = "(A)(B)"
        val actual = parseTokenGraph(source)
        assertEquals(
            listOf(ObjCTokenNode("", ObjCTokenNode("A")), ObjCTokenNode("", ObjCTokenNode("B"))),
            actual
        )
    }

    @Test
    fun `test - (A B))`() {
        val source = "(A B)"
        val actual = parseTokenGraph(source)
        assertEquals(
            listOf(ObjCTokenNode("", listOf(ObjCTokenNode("A"), ObjCTokenNode("B")))),
            actual
        )
    }

    @Test
    fun `test - (A B)(C D)`() {
        val source = "(A B)(C D)"
        val actual = parseTokenGraph(source)
        assertEquals(
            listOf(
                ObjCTokenNode("", listOf(ObjCTokenNode("A"), ObjCTokenNode("B"))),
                ObjCTokenNode("", listOf(ObjCTokenNode("C"), ObjCTokenNode("D"))),
            ),
            actual
        )
    }

    @Test
    fun `test - X(A B)`() {
        val source = "X(A B)"
        val actual = parseTokenGraph(source)
        assertEquals(
            listOf(ObjCTokenNode("X", listOf(ObjCTokenNode("A"), ObjCTokenNode("B")))),
            actual
        )
    }
}
