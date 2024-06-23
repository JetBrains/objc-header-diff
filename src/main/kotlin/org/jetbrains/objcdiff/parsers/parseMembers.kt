package org.example.org.jetbrains.objcdiff.parsers

import org.example.org.jetbrains.objcdiff.DiffContext
import org.example.org.jetbrains.objcdiff.ObjCMember

context(DiffContext)
fun List<String>.parseMembers(): List<ObjCMember> {
    return mapNotNull {
        if (it.startsWith("@required")) return@mapNotNull null
        it.parseProperty() ?: it.parseMethod()
    }
}