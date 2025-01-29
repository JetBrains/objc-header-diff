package org.jetbrains.objcdiff.parsers

import org.jetbrains.objcdiff.DiffContext
import org.jetbrains.objcdiff.ObjCProperty

context(DiffContext)
fun String.parseProperty(): ObjCProperty? {
    if (!this.startsWith("@property")) {
        return null
    }
    val nullable = this.contains("_Nullable")
    val raw = this
        .replace("* ", "")
        .replace("*", "")
        .replace("_Nullable", "")
        .replace(Regex("\\(.*?\\)"), "")
        .substringBefore("__attribute__")
        .substringAfter("@property")
        .replace("  ", " ")
        .trim()

    val nameAndType = raw.split(" ")

    return if (nameAndType.size == 2) {
        ObjCProperty(
            name = nameAndType[1],
            type = nameAndType[0].parseType(),
            nullable = nullable
        )
    } else {
        null
    }
}