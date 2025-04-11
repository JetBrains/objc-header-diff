package org.jetbrains.objcdiff

import org.jetbrains.objcdiff.parsers.getMethodSwiftAttribute
import kotlin.test.Test
import kotlin.test.assertEquals

class GetMethodSwiftNameAttributeTest {
    @Test
    fun `test - receiver`() {
        val method = "- (BOOL)days:(BOOL)receiver __attribute__((swift_name(\"days(_:)\")));"
        assertEquals("days(_:)", method.getMethodSwiftAttribute())
    }

    @Test
    fun `test - constructor`() {
        val method =
            "- (instancetype)init __attribute__((swift_name(\"init()\"))) __attribute__((objc_designated_initializer));"
        assertEquals("init()", method.getMethodSwiftAttribute())
    }

    @Test
    fun `test - constructor with multiple constructors`() {
        val method =
            "- (instancetype)initWithA:(int32_t)a b:(int32_t)b __attribute__((swift_name(\"init(a:b:)\"))) __attribute__((objc_designated_initializer));"
        assertEquals("init(a:b:)", method.getMethodSwiftAttribute())
    }
}