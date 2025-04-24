package org.jetbrains.objcdiff

import org.jetbrains.objcdiff.utils.foldIndexedSkippable
import kotlin.test.Test
import kotlin.test.assertEquals

class TestFoldIndexedSkippable {
    @Test
    fun `skip even`() {
        val list = listOf(1, 2, 3, 4, 5)
        val result = list.foldIndexedSkippable(emptyList<Int>()) { index, acc, value, skip ->
            if (index.value % 2 == 0) skip(1)
            acc + value
        }
        assertEquals(listOf(1, 3, 5), result)
    }

    @Test
    fun `skip two consecutive`() {
        val list = listOf(1, 2, 3, 4, 5, 6)
        val result = list.foldIndexedSkippable(emptyList<Int>()) { index, acc, value, skip ->
            if (value == 2) {
                skip(2)
            }
            acc + value
        }
        assertEquals(listOf(1, 2, 5, 6), result)
    }
}