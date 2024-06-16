package org.example.org.jetbrains.objcdiff.reports

import org.example.org.jetbrains.objcdiff.ObjCClassOrInterface

data class HeaderReport(
    val fileName: String,
    val protocols: List<ObjCClassOrInterface>,
    val interfaces: List<ObjCClassOrInterface>
) : Report() {
    val allSymbolsMap = (protocols + interfaces).associateBy { it.key }
}