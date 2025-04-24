package org.jetbrains.objcdiff.utils

import org.jetbrains.objcdiff.DiffContext
import org.jetbrains.objcdiff.ObjCType
import org.jetbrains.objcdiff.reports.toObjCTypes

context(DiffContext)
fun String.getFirstType(): ObjCType {
    return trimIndent().toObjCTypes().toList().first()
}

context(DiffContext)
fun String.getFirstClassifier(): ObjCType.ObjectType {
    return trimIndent().toObjCTypes().toList().first() as ObjCType.ObjectType
}

context(DiffContext)
fun String.parseClassifiers(): List<ObjCType.ObjectType> {
    return trimIndent().toObjCTypes().toList().map { it as ObjCType.ObjectType }
}