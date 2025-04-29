package org.jetbrains.objcdiff

import org.jetbrains.objcdiff.swift.SwiftCallPrinter
import org.jetbrains.objcdiff.swift.makeSwiftCall
import org.jetbrains.objcdiff.utils.getFirstObjCObject
import kotlin.test.Test

class TestObjCToSwiftTranslation {
    @Test
    fun test() {
        val swiftPrinter = SwiftCallPrinter()

        with(ObjCContext()) {
            val obj = """
            @interface Foo
            - (instancetype)init;
            + (void)bar:(int32_t)a b:(int32_t)b;
            @end
        """.getFirstObjCObject()

            makeSwiftCall(obj)
        }
    }
}