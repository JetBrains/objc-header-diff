package org.jetbrains.objcdiff.parsers

import org.jetbrains.objcdiff.ClassifierType
import org.jetbrains.objcdiff.DiffContext
import org.jetbrains.objcdiff.ObjCType

context(DiffContext)
fun String.parseType(classOrInterface: ClassifierType = ClassifierType.Undefined): ObjCType {
    val nullable = this.contains("_Nullable")
    val raw = this.replace(" *", "")
        .replace("_Nullable", "")
        .replace("struct", "")
        .replace("__contravariant", "")
        .replace("__covariant", "")
        .replace(" (Extensions)", "Extensions")
        .replace("><", ",")

    val typeRegex = Regex("([a-zA-Z0-9_]+)( )?(<.*>)?")
    val matchResult = typeRegex.matchEntire(raw.trim())

    require(matchResult != null) { "Invalid type format: `$raw` with original `$this`" }

    val (name, _, genericsPart) = matchResult.destructured

    val generics = if (genericsPart.isNotBlank()) {
        parseGenerics(genericsPart)
    } else {
        emptyList()
    }

    return buildType(
        name = name,
        generics = generics,
        nullable = nullable,
        classifierType = classOrInterface,
        members = emptyList(),
        superType = null
    )
}