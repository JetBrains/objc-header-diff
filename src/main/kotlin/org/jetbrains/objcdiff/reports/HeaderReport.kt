package org.jetbrains.objcdiff.reports

import org.jetbrains.objcdiff.ClassifierType
import org.jetbrains.objcdiff.ObjCType

data class HeaderReport(
    val fileName: String,
    val types: List<ObjCType>
) : Report() {
    val allTypes = (types).associateBy { it.key }

    val protocols = types.filterIsInstance<ObjCType.ObjectType>().filter { it.type == ClassifierType.Protocol }
    val interfaces = types.filterIsInstance<ObjCType.ObjectType>().filter { it.type == ClassifierType.Interface }
}