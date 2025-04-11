package org.jetbrains.objcdiff

import org.jetbrains.objcdiff.parsers.getMethodSwiftArguments
import org.jetbrains.objcdiff.parsers.getMethodSwiftName
import kotlin.test.Test
import kotlin.test.assertEquals

class ParseMethodSwiftNameAttributeTest {
    @Test
    fun `test - receiver`() {
        val attr = "days(_:)"
        assertEquals("days", attr.getMethodSwiftName())
        assertEquals(listOf("_"), attr.getMethodSwiftArguments())
    }

    @Test
    fun `test - constructor`() {
        val attr = "init()"
        assertEquals("init", attr.getMethodSwiftName())
        assertEquals(listOf(), attr.getMethodSwiftArguments())
    }

    @Test
    fun `test - constructor with multiple constructors`() {
        val attr = "init(a:b:)"
        assertEquals("init", attr.getMethodSwiftName())
        assertEquals(listOf("a", "b"), attr.getMethodSwiftArguments())
    }
}