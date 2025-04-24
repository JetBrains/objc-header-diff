package org.jetbrains.objcdiff

import org.jetbrains.objcdiff.parsers.consumePrefix
import kotlin.test.Test
import kotlin.test.assertEquals

class TestConsumePrefix {
    @Test
    fun `test - basic prefix`() {
        val reminder = "AB".consumePrefix("A") { consumed ->
            assertEquals("A", consumed)
        }
        assertEquals("B", reminder)
    }

    @Test
    fun `test - brackets prefix`() {
        val reminder = "(A)B".consumePrefix("""\((.*?)\)""") { consumed ->
            assertEquals("(A)", consumed)
        }
        assertEquals("B", reminder)
    }

    @Test
    fun `test - method prefix`() {
        val reminder = "+ name".consumePrefix("""[+-] """) { consumed ->
            assertEquals("+ ", consumed)
        }
        assertEquals("name", reminder)
    }
}