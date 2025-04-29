package org.jetbrains.objcdiff

import org.jetbrains.objcdiff.swift.SwiftCallPrinter
import org.jetbrains.objcdiff.swift.SwiftFunction
import org.jetbrains.objcdiff.swift.asSwiftType
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
                "a" to ObjCType.PrimitiveType(name = "BOOL").asSwiftType()
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
                "a" to ObjCType.PrimitiveType(name = "BOOL").asSwiftType(),
                "b" to ObjCType.PrimitiveType(name = "NSString").asSwiftType()
            ),
            container = null
        )

        val expected = """
            bar(a: true, b: "")
        """.trimIndent()
        val actual = printer.add(foo).print()
        assertEquals(expected, actual)
    }
}