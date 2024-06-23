package org.example.org.jetbrains.objcdiff.reports

import org.example.org.jetbrains.objcdiff.ObjCType

data class HeaderReport(
    val fileName: String,
    val types: List<ObjCType>
) : Report() {
    val allSymbolsMap = (types).associateBy { it.key }

    val protocols = types.filter { it.classOrInterface == "protocol" }
    val interfaces = types.filter { it.classOrInterface == "interface" }
}