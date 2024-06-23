package org.example.org.jetbrains.objcdiff.parsers

import org.example.org.jetbrains.objcdiff.DiffContext
import org.example.org.jetbrains.objcdiff.ObjCType

context(DiffContext)
fun parseGenerics(genericsPart: String): List<ObjCType> {
    val cleanedGenerics = genericsPart.removeSurrounding("<", ">")
    val generics = mutableListOf<String>()
    var depth = 0
    var currentGeneric = StringBuilder()

    for (char in cleanedGenerics) {
        when (char) {
            '<' -> {
                depth++
                currentGeneric.append(char)
            }

            '>' -> {
                depth--
                currentGeneric.append(char)
            }

            ',' -> {
                if (depth == 0) {
                    generics.add(currentGeneric.toString().trim())
                    currentGeneric = StringBuilder()
                } else {
                    currentGeneric.append(char)
                }
            }

            else -> currentGeneric.append(char)
        }
    }

    if (currentGeneric.isNotBlank()) {
        generics.add(currentGeneric.toString().trim())
    }

    return generics.map { it.parseType() }
}