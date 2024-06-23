package org.example.org.jetbrains.objcdiff.parsers

import org.example.org.jetbrains.objcdiff.reports.interfacePrefix
import org.example.org.jetbrains.objcdiff.reports.protocolPrefix

fun String.parseObjCTypeHeader(): ObjCTypeHeader {

    val protocolOrInterface: String

    val raw = if (this.startsWith(interfacePrefix)) {
        protocolOrInterface = "protocol"
        this.replace(interfacePrefix, "")
    } else {
        protocolOrInterface = "interface"
        this.replace(protocolPrefix, "")
    }.trim()

    val rawMain = raw.substringBefore(":")
    val rawSuperType = if (raw.contains(":")) raw.parseSuperType() else null

    return ObjCTypeHeader(rawMain, rawSuperType, protocolOrInterface)
}

data class ObjCTypeHeader(
    val rawMain: String,
    val rawSuper: String?,
    val protocolOrInterface: String
) {
    val key = rawMain
}