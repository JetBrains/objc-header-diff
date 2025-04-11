package org.jetbrains.objcdiff.reports

import org.jetbrains.objcdiff.DiffContext
import org.jetbrains.objcdiff.ObjCType
import org.jetbrains.objcdiff.parsers.ObjCTypeHeader
import org.jetbrains.objcdiff.parsers.parseMembers
import org.jetbrains.objcdiff.parsers.parseObjCTypeHeader
import org.jetbrains.objcdiff.parsers.parseType
import org.jetbrains.objcdiff.utils.loadFile
import java.io.File

val startComment = "^/\\*\\*.*".toRegex()
val endComment = "\\*/".toRegex()

const val interfacePrefix = "@interface"
const val protocolPrefix = "@protocol"

val startInterface = "$interfacePrefix.*".toRegex()
val startProtocol = "$protocolPrefix.*".toRegex()
val end = "@end".toRegex()

context(DiffContext)
fun buildHeaderReport(file: File): HeaderReport {
    return buildHeaderReport(file.name, loadFile(file))
}

context(DiffContext)
fun buildHeaderReport(fileName: String, source: String): HeaderReport {
    val sequence = source
        .lineSequence()
        .skipEmpty()
        .skipGroup(startComment, endComment)
        .skipForwardProtocols()

    return HeaderReport(
        fileName = fileName,
        types = sequence.toObjCTypes().toList()
    )
}

context(DiffContext)
fun String.collectClassesAndProtocols(): List<ObjCType> {
    return lineSequence().toObjCTypes().toList()
}

fun Sequence<String>.skipEmpty(): Sequence<String> = sequence {
    for (str in this@skipEmpty) if (str.isNotEmpty()) yield(str)
}

fun Sequence<String>.skipGroup(start: Regex, end: Regex): Sequence<String> = sequence {
    var skip = false
    for (str in this@skipGroup) {
        when {
            str.matches(start) -> skip = true
            str.matches(end) -> skip = false
            !skip -> yield(str)
        }
    }
}

fun Sequence<String>.skipForwardProtocols(): Sequence<String> = sequence {
    val protocols = count { it.startsWith("@protocol") }
    val interfaces = count { it.startsWith("@interface") }
    val ends = count { it.startsWith("@end") }

    if (protocols + interfaces == ends) {
        yieldAll(this@skipForwardProtocols)
    } else {
        yieldAll(this@skipForwardProtocols.drop(indexOfFirst { it.startsWith("@protocol") } + 1))
    }
}

context(DiffContext)
fun String.toObjCTypes(): Sequence<ObjCType> {
    return lineSequence().toObjCTypes()
}

context(DiffContext)
fun Sequence<String>.toObjCTypes() = sequence {
    var take = false
    var header: ObjCTypeHeader? = null
    val rawMembers = mutableListOf<String>()
    for (str in this@toObjCTypes) {
        when {
            str.matches(startProtocol) || str.matches(startInterface) -> {
                header = str.parseObjCTypeHeader()
                take = true
                rawMembers.clear()
            }

            str.matches(end) && take -> {
                take = false
                yield(
                    parseType(header ?: error("header types isn't initialised"), rawMembers)
                )
            }

            take -> {
                rawMembers.add(str)
            }
        }
    }
}

context(DiffContext)
fun parseType(
    header: ObjCTypeHeader,
    members: List<String> = emptyList()
): ObjCType {
    val mainType = header.rawMain.parseType(header.classifierType)
    val superType = header.rawSuper?.parseType(header.classifierType)
    return buildType(
        name = mainType.name,
        generics = mainType.generics,
        nullable = mainType.nullable,
        classifierType = header.classifierType,
        members = members.parseMembers(mainType),
        superType = superType
    )
}