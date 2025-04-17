package org.jetbrains.objcdiff

import org.jetbrains.objcdiff.parsers.consumeUntilOrEnd
import kotlin.test.Test
import kotlin.test.assertEquals

class ConsumeUntilTest {
    @Test
    fun test() {
        consumeUntilOrEnd(':', "ABC:", 0) { result, pointer ->
            assertEquals("ABC", result)
            assertEquals(4, pointer)
        }
    }
}