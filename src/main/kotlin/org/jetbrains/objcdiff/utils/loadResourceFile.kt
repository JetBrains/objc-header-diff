package org.jetbrains.objcdiff.utils

fun loadResourceFile(fileName: String): String {
    val classLoader = Thread.currentThread().contextClassLoader
    val resource = classLoader.getResource(fileName)
    return resource?.readText() ?: throw IllegalArgumentException("File `$fileName` not found in `resources`")
}