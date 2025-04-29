package org.jetbrains.objcdiff

import org.jetbrains.objcdiff.swift.asSwiftMethod
import org.jetbrains.objcdiff.utils.getFirstObjCObject
import org.jetbrains.objcdiff.utils.second
import kotlin.test.Test
import kotlin.test.assertEquals

class GenerateSwiftIRFromObjC {
    @Test
    fun `test - invalid order`() {

        val source = """
            @interface Foo : Base
                - (BOOL)days:(BOOL)receiver __attribute__((swift_name("days(_:)")));
                - (int32_t)days_:(int32_t)receiver __attribute__((swift_name("days(__:)")));
                - (NSString *)days__:(NSString *)receiver __attribute__((swift_name("days(___:)")));
                - (instancetype)initWithA:(int32_t)a b:(int32_t)b __attribute__((swift_name("init(a:b:)"))) __attribute__((objc_designated_initializer));
            @end
        """

        with(ObjCContext()) {
            val objc = source.getFirstObjCObject()


            (objc.members[0] as ObjCMethod).asSwiftMethod().apply {
                assertEquals("days", this.name)
                assertEquals("_", this.arguments.keys.first())
                assertEquals("BOOL", this.arguments.values.first().name)
            }

            (objc.members[1] as ObjCMethod).asSwiftMethod().apply {
                assertEquals("days", this.name)
                assertEquals("__", this.arguments.keys.first())
                assertEquals("int32_t", this.arguments.values.first().name)
            }

            (objc.members[2] as ObjCMethod).asSwiftMethod().apply {
                assertEquals("days", this.name)
                assertEquals("___", this.arguments.keys.first())
                assertEquals("NSString", this.arguments.values.first().name)
            }
            (objc.members[3] as ObjCMethod).asSwiftMethod().apply {
                assertEquals("init", this.name)
                assertEquals("a", this.arguments.keys.first())
                assertEquals("b", this.arguments.keys.second())
            }
        }
    }
}