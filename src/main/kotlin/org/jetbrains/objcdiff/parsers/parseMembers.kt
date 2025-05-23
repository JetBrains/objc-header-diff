package org.jetbrains.objcdiff.parsers

import org.jetbrains.objcdiff.DiffContext
import org.jetbrains.objcdiff.ObjCMember
import org.jetbrains.objcdiff.ObjCType

context(DiffContext)
fun List<String>.parseMembers(container: ObjCType?): List<ObjCMember> {
    return mapNotNull {
        if (it.startsWith("@required")) return@mapNotNull null
        if (it.endsWith("__attribute__((unavailable));")) return@mapNotNull null
        it.parseProperty(container) ?: it.parseMethod(container)
    }
}