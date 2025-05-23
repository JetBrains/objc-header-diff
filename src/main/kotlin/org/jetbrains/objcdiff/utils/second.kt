package org.jetbrains.objcdiff.utils

fun <T> Iterable<T>.second(): T {
    when (this) {
        is List -> return this[1]
        else -> {
            val iterator = iterator()
            if (!iterator.hasNext())
                throw NoSuchElementException("Collection is empty.")
            iterator.next()
            return iterator.next()
        }
    }
}