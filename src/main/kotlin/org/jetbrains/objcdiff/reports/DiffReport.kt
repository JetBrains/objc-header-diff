package org.jetbrains.objcdiff.reports

import org.jetbrains.objcdiff.ObjCType

data class DiffReport(
    val expectedButNotDefined: Set<String>,
    val definedButNotExpected: Set<String>,
    val unequalMembers: Set<String>,
    val invalidOrderTypes: Set<String>,
    val merge: List<ObjCType>
) : Report()