package org.jetbrains.objcdiff.parsers

import org.jetbrains.objcdiff.DiffContext
import org.jetbrains.objcdiff.ObjCMember

context(DiffContext)
fun List<String>.parseMembers(): List<ObjCMember> {
    return mapNotNull {
        if (it.startsWith("@required")) return@mapNotNull null
        it.parseProperty() ?: it.parseMethod()
    }
}