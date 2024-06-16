package org.example.org.jetbrains.objcdiff.utils

import java.io.File
import java.io.IOException

fun storeFile(fileName: String, data: String) {
    val file = File("out/$fileName")

    try {
        file.parentFile.mkdirs()
        file.writeText(data)
    } catch (e: IOException) {
        println("An error occurred while saving the text: ${e.message}")
    }
}