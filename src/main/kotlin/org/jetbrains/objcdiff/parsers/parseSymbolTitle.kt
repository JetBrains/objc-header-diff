package org.jetbrains.objcdiff.parsers

import org.jetbrains.objcdiff.ClassifierType
import org.jetbrains.objcdiff.reports.interfacePrefix
import org.jetbrains.objcdiff.reports.protocolPrefix

fun String.parseObjCTypeHeader(): ObjCTypeHeader {

    val classifierType: ClassifierType

    val raw = if (this.startsWith(interfacePrefix)) {
        classifierType = ClassifierType.Protocol
        this.replace(interfacePrefix, "")
    } else {
        classifierType = ClassifierType.Interface
        this.replace(protocolPrefix, "")
    }.trim()

    val rawMain = raw.substringBefore(":")
    val rawSuperType = if (raw.contains(":")) raw.parseSuperType() else null

    return ObjCTypeHeader(rawMain, rawSuperType, classifierType)
}

data class ObjCTypeHeader(
    val rawMain: String,
    val rawSuper: String?,
    val classifierType: ClassifierType
) {
    val key = rawMain
}