package org.example.org.jetbrains.objcdiff.reports

import org.example.org.jetbrains.objcdiff.ObjCClassOrInterface

data class DiffReport(
    val expectedButNotDefined: Int,
    val definedButNotExpected: Int,
    val unequalMembers: Int,
    val merge: List<ObjCClassOrInterface>
): Report()