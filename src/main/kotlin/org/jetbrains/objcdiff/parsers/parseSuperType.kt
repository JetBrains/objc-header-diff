package org.example.org.jetbrains.objcdiff.parsers

/**
 * - `A : B` > `B`
 * - `A : B<C>` > `B<C>`
 * - `A : B<C *>` > `B<C>`
 * - `A` > `null`
 */
fun String.parseSuperType(): String? {
    if (this.contains("@")) throw IllegalArgumentException("`@` prefix must be removed")
    val rawType = replace('*', ' ').replace(" ", "")
    val split = rawType.indexOf(':')
    if (split == -1) return null
    return rawType.substringAfter(':').trim()
}