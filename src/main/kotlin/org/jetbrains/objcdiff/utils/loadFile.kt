package org.jetbrains.objcdiff.utils

import java.io.File

fun loadFile(file: File): String {
    if (!file.exists()) error("File ${file.path} doesn't exists")
    return file.readText()
}

fun loadFile(path: String): String {
    return loadFile(File(path))
}