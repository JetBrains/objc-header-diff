package org.jetbrains.objcdiff

import org.jetbrains.objcdiff.parsers.GroupToken
import org.jetbrains.objcdiff.parsers.parseGroupToken
import kotlin.test.Test
import kotlin.test.assertEquals

class ParseGroupTokenTest {

    @Test
    fun `test - empty`() {
        val result = parseGroupToken("")
        assertEquals(GroupToken(""), result)
    }

    @Test
    fun `test - generic`() {
        val result = parseGroupToken("T", 0)
        assertEquals(GroupToken("T"), result)
    }

    @Test
    fun `test - nested generics`() {
        val result = parseGroupToken("A<B>", 0)
        assertEquals(GroupToken("A", listOf(GroupToken("B"))), result)
    }

    @Test
    fun `test - multiple nested generics`() {
        val result = parseGroupToken("A<B<C>>>", 0)
        assertEquals(
            GroupToken("A", listOf(GroupToken("B", listOf(GroupToken("C"))))),
            result
        )
    }

    @Test
    fun `test - nullable generic lambda`() {
        val source = "(T _Nullable (^)(Int *))"
        val actual = parseGroupToken(source)

        val expected = GroupToken(
            "",
            GroupToken(
                "T _Nullable",
                listOf(GroupToken("^"), GroupToken("Int *"))
            )
        )

        assertEquals(expected, actual)
    }
}
