package org.example.org.jetbrains.objcdiff.utils

import org.example.org.jetbrains.objcdiff.ObjCType

fun areConnected(from: ObjCType, to: ObjCType): Boolean {
    val fromSuper = from.superType
    if (fromSuper != null && fromSuper.key == to.key) return true
    if (fromSuper != null) {
        if (areConnected(fromSuper, to)) {
            return true
        }
    }
    return false
}