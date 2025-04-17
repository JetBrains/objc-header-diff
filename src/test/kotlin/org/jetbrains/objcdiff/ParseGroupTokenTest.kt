package org.jetbrains.objcdiff

import org.jetbrains.objcdiff.parsers.GroupToken
import org.jetbrains.objcdiff.parsers.parseGroupToken
import kotlin.test.Test
import kotlin.test.assertEquals

class ParseGroupTokenTest {

    @Test
    fun `test - empty`() {
        val result = parseGroupToken("")
        assertEquals(emptyList(), result)
    }

    @Test
    fun `test - generic`() {
        val result = parseGroupToken("T", 0)
        assertEquals(listOf(GroupToken("T")), result)
    }

    @Test
    fun `test - nested generics`() {
        val result = parseGroupToken("A<B>", 0)
        assertEquals(listOf(GroupToken("A", GroupToken("B"))), result)
    }

    @Test
    fun `test - multiple nested generics`() {
        val result = parseGroupToken("A<B<C>>>", 0)
        assertEquals(
            listOf(GroupToken("A", GroupToken("B", GroupToken("C")))),
            result
        )
    }

    @Test
    fun `test - t nullable`() {
        val source = "T _Nullable"
        val actual = parseGroupToken(source)

        assertEquals(listOf(GroupToken("T"), GroupToken("_Nullable")), actual)
    }

    @Test
    fun `test - T _Nullable (A)(B C)`() {
        val source = "T _Nullable (A)(B C)"
        val actual = parseGroupToken(source)

        val expected = listOf(
            GroupToken("T"),
            GroupToken("_Nullable"),
            GroupToken("", GroupToken("A")),
            GroupToken("", listOf(GroupToken("B"), GroupToken("C")))
        )

        assertEquals(expected, actual)
    }

    @Test
    fun `test - (A)(B)`() {
        val source = "(A)(B)"
        val actual = parseGroupToken(source)
        assertEquals(
            listOf(GroupToken("", GroupToken("A")), GroupToken("", GroupToken("B"))),
            actual
        )
    }

    @Test
    fun `test - (A B))`() {
        val source = "(A B)"
        val actual = parseGroupToken(source)
        assertEquals(
            listOf(GroupToken("", listOf(GroupToken("A"), GroupToken("B")))),
            actual
        )
    }

    @Test
    fun `test - (A B)(C D)`() {
        val source = "(A B)(C D)"
        val actual = parseGroupToken(source)
        assertEquals(
            listOf(
                GroupToken("", listOf(GroupToken("A"), GroupToken("B"))),
                GroupToken("", listOf(GroupToken("C"), GroupToken("D"))),
            ),
            actual
        )
    }

    @Test
    fun `test - X(A B)`() {
        val source = "X(A B)"
        val actual = parseGroupToken(source)
        assertEquals(
            listOf(GroupToken("X", listOf(GroupToken("A"), GroupToken("B")))),
            actual
        )
    }
}
