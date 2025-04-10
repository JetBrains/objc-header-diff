package org.jetbrains.objcdiff

import org.jetbrains.objcdiff.reports.verifyMembersOrder
import org.jetbrains.objcdiff.utils.getFirstType
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TestOrderDiff {
    @Test
    fun `test - invalid order`() {
        with(DiffContext()) {
            val orderA = """
            @interface Foo
                (int32_t)bar1
                (int32_t)bar2
            @end
        """.getFirstType()
            val orderB = """
            @interface Foo
                (int32_t)bar2
                (int32_t)bar1
            @end
        """.getFirstType()
            assertFalse(verifyMembersOrder(orderA, orderB))
        }
    }

    @Test
    fun `test - valid order`() {
        with(DiffContext()) {
            val orderA = """
            @interface Foo
                (int32_t)bar1
                (int32_t)bar2
            @end
        """.getFirstType()
            val orderB = """
            @interface Foo
                (int32_t)bar1
                (int32_t)bar2
            @end
        """.getFirstType()
            assertTrue(verifyMembersOrder(orderA, orderB))
        }
    }
}