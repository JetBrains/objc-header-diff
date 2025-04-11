package org.jetbrains.objcdiff.reports

import org.jetbrains.objcdiff.ClassifierType
import org.jetbrains.objcdiff.ObjCType

data class HeaderReport(
    val fileName: String,
    val types: List<ObjCType>
) : Report() {
    val allSymbolsMap = (types).associateBy { it.key }

    val protocols = types.filter { it.classifierType == ClassifierType.Protocol }
    val interfaces = types.filter { it.classifierType == ClassifierType.Interface }
}