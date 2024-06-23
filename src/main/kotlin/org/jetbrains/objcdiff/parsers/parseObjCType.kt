package org.example.org.jetbrains.objcdiff.parsers

import org.example.org.jetbrains.objcdiff.ObjCType

fun String.parseType(): ObjCType {
    val nullable = this.contains("_Nullable")
    val raw = this.replace(" *", "")
        .replace("_Nullable", "")
        .replace("struct", "")
        .replace("__contravariant", "")
        .replace("__covariant", "")
        .replace(" (Extensions)", "Extensions")
        .replace("><", ",")
    //val raw = this.substringBefore(" ").replace("*", "")
    val typeRegex = Regex("([a-zA-Z0-9_]+)( )?(<.*>)?")
    val matchResult = typeRegex.matchEntire(raw.trim())

    require(matchResult != null) { "Invalid type format: `$raw` with original `$this`" }

    val (name, _, genericsPart) = matchResult.destructured

    val generics = if (genericsPart.isNotBlank()) {
        parseGenerics(genericsPart)
    } else {
        emptyList()
    }

    return ObjCType(
        key = raw,
        name = name,
        generics = generics,
        nullable = nullable,
        classOrInterface = "class",
        members = emptyList(),
        superType = null
    )

    //return ObjCType(name, generics, nullable)
}