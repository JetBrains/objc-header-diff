package org.jetbrains.objcdiff.utils

import org.jetbrains.objcdiff.ObjCContext
import org.jetbrains.objcdiff.ObjCType
import org.jetbrains.objcdiff.reports.toObjCTypes

context(ObjCContext)
fun String.getFirstObjCType(): ObjCType {
    return trimIndent().toObjCTypes().toList().first()
}

context(ObjCContext)
fun String.getFirstObjCObject(): ObjCType.ObjectType {
    return trimIndent().toObjCTypes().toList().first() as ObjCType.ObjectType
}

context(ObjCContext)
fun String.parseObjCObjects(): List<ObjCType.ObjectType> {
    return trimIndent().toObjCTypes().toList().map { it as ObjCType.ObjectType }
}