package org.jetbrains.objcdiff

import org.jetbrains.objcdiff.swift.SwiftCallPrinter
import org.jetbrains.objcdiff.swift.SwiftFunction
import kotlin.test.Test
import kotlin.test.assertEquals

class SwiftCallPrinterTest {
    @Test
    fun `test - top level function`() {
        val printer = SwiftCallPrinter()
        val foo = SwiftFunction(
            name = "bar",
            isStatic = true,
            isConstructor = false,
            arguments = emptyMap(),
            container = null
        )

        val expectedSwift = """
            bar()
        """.trimIndent()

        assertEquals(expectedSwift, printer.add(foo).print())
    }

    @Test
    fun `test - top level function with one param`() {
        val printer = SwiftCallPrinter()
        val foo = SwiftFunction(
            name = "bar",
            isStatic = true,
            isConstructor = false,
            arguments = mapOf(
                "a" to ObjCType(name = "BOOL").asSwiftType()!!
            ),
            container = null
        )

        val expectedSwift = """
            bar(a: true)
        """.trimIndent()

        assertEquals(expectedSwift, printer.add(foo).print())
    }

    @Test
    fun `test - top level function with two params`() {
        val printer = SwiftCallPrinter()
        val foo = SwiftFunction(
            name = "bar",
            isStatic = true,
            isConstructor = false,
            arguments = mapOf(
                "a" to ObjCType(name = "BOOL").asSwiftType()!!
            ),
            container = null
        )

        val expectedSwift = """
            bar(a: true)
        """.trimIndent()

        assertEquals(expectedSwift, printer.add(foo).print())
    }
}