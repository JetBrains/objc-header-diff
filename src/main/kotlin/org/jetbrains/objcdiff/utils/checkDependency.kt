package org.jetbrains.objcdiff.utils

import org.jetbrains.objcdiff.ObjCProperty
import org.jetbrains.objcdiff.ObjCType

/**
 * class A, class B - are not connected
 * class A, class B : A is not connected with, but B is connected with A
 */
fun checkDependency(from: ObjCType?, to: ObjCType): Boolean {
    if (from == null) return false
    val fromSuper = from.superType
    if (fromSuper != null && fromSuper.key == to.key) return true
    if (fromSuper != null) {
        if (checkDependency(fromSuper, to)) {
            return true
        }
    }

    from.members.forEach { member ->
        if (member is ObjCProperty) {
            if (member.type.key == to.key) {
                return true
            } else {
                if (checkDependency(member.type.superType, to)) {
                    return true
                }
            }
        }
    }

    return false
}