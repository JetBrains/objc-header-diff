package org.jetbrains.objcdiff

import org.jetbrains.objcdiff.reports.verifyMembersOrder
import org.jetbrains.objcdiff.utils.getFirstObjCType
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TestOrderDiff {
    @Test
    fun `test - invalid order`() {
        with(ObjCContext()) {
            val orderA = """
            @interface Foo
                + (void) bar1(int32_t)bar1
                + (void) bar2(int32_t)bar2
            @end
        """.getFirstObjCType()
            val orderB = """
            @interface Foo
                + (void) bar2(int32_t)bar2
                + (void) bar1(int32_t)bar1
            @end
        """.getFirstObjCType()
            assertFalse(verifyMembersOrder(orderA, orderB))
        }
    }

    @Test
    fun `test - valid order`() {
        with(ObjCContext()) {
            val orderA = """
            @interface Foo
                + (void) bar1(int32_t)bar1
                + (void) bar2(int32_t)bar2
            @end
        """.getFirstObjCType()
            val orderB = """
            @interface Foo
                + (void) bar1(int32_t)bar1
                + (void) bar2(int32_t)bar2
            @end
        """.getFirstObjCType()
            assertTrue(verifyMembersOrder(orderA, orderB))
        }
    }
}