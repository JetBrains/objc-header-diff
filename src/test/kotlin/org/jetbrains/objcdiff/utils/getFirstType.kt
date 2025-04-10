package org.jetbrains.objcdiff.utils

import org.jetbrains.objcdiff.DiffContext
import org.jetbrains.objcdiff.ObjCType
import org.jetbrains.objcdiff.reports.toObjCTypes

context(DiffContext)
fun String.getFirstType(): ObjCType {
    return trimIndent().toObjCTypes().toList().first()
}