package org.jetbrains.objcdiff.utils

import org.jetbrains.objcdiff.ObjCProperty
import org.jetbrains.objcdiff.ObjCType
import org.jetbrains.objcdiff.getSuperTypeOrNull

/**
 * class A, class B - are not connected
 * class A, class B : A is not connected with, but B is connected with A
 */
fun checkDependency(from: ObjCType?, to: ObjCType): Boolean {
    if (from == null) return false
    if (from is ObjCType.ObjectType) {
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
                    if (checkDependency(member.type.getSuperTypeOrNull(), to)) {
                        return true
                    }
                }
            }
        }
    }

    return false
}