package org.jetbrains.objcdiff

import org.jetbrains.objcdiff.parsers.parseTokenGraph
import kotlin.test.Test

class TestGroupTokenParsing {
    @Test
    fun test() {
        val p = parseTokenGraph("SharedBase (SharedBaseCopying) <NSCopying>")
        println(p)
    }
}