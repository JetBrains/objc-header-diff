package org.example.org.jetbrains.objcdiff.parsers

fun String.parseSymbolTitle(symbolType: String): SymbolTitle {

    val raw = this.replace("@$symbolType", "").trim()
    val rawMain = raw.substringBefore(":")
    val rawSuperType = if (raw.contains(":")) raw.parseSuperType() else null

    return SymbolTitle(rawMain, rawSuperType)
}

data class SymbolTitle(val rawMain: String, val rawSuper: String?)