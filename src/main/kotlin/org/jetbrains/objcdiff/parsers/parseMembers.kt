package org.example.org.jetbrains.objcdiff.parsers

import org.example.org.jetbrains.objcdiff.ObjCMember

fun List<String>.parseMembers(): List<ObjCMember> {
    return mapNotNull {
        if (it.startsWith("@required")) return@mapNotNull null
        it.parseProperty() ?: it.parseMethod()
    }
}