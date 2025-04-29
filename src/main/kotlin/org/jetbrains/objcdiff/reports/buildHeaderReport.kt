package org.jetbrains.objcdiff.reports

import org.jetbrains.objcdiff.ObjCContext
import org.jetbrains.objcdiff.ObjCType
import org.jetbrains.objcdiff.parsers.*
import org.jetbrains.objcdiff.utils.loadFile
import java.io.File

val startComment = "^/\\*\\*.*".toRegex()
val endComment = "\\*/".toRegex()

const val interfacePrefix = "@interface"
const val protocolPrefix = "@protocol"

val startInterface = "$interfacePrefix.*".toRegex()
val startProtocol = "$protocolPrefix.*".toRegex()
val end = "@end".toRegex()

context(ObjCContext)
fun buildHeaderReport(file: File): HeaderReport {
    return buildHeaderReport(file.name, loadFile(file))
}

context(ObjCContext)
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

context(ObjCContext)
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

context(ObjCContext)
fun String.toObjCTypes(): Sequence<ObjCType> {
    return lineSequence().toObjCTypes()
}

context(ObjCContext)
fun Sequence<String>.toObjCTypes() = sequence {
    var take = false
    var header: ObjCTypeHeader? = null
    val rawMembers = mutableListOf<String>()
    var swiftName: String? = null
    for (str in this@toObjCTypes) {
        currentLine = str
        when {
            str.startsWith("__attribute__((swift_name(") -> {
                swiftName = str.getMethodSwiftAttribute()
            }

            str.matches(startProtocol) || str.matches(startInterface) -> {
                header = str.parseObjCTypeHeader(swiftName)
                take = true
                rawMembers.clear()
            }

            str.matches(end) && take -> {
                take = false
                yield(
                    buildObjectType(header ?: error("header types isn't initialised"), rawMembers)
                )
                swiftName = null
            }

            take -> {
                rawMembers.add(str)
            }
        }
    }
}

context(ObjCContext)
fun buildObjectType(
    header: ObjCTypeHeader,
    members: List<String> = emptyList(),
): ObjCType.ObjectType {
    //TODO("Parse type with a special function: rawMain=`SharedBase (SharedBaseCopying) <NSCopying>` >>> just drop whats in brackets")
    //parseTokenGraph(header.rawMain)

    val mainType = header.rawMain.parseMainType().parseObjCType(header.classifierType) as ObjCType.ObjectType
    val superType = header.rawSuper?.parseObjCType(header.classifierType) as? ObjCType.ObjectType

    return buildObjectType(
        mainType.name,
        mainType.generics,
        members.parseMembers(mainType),
        mainType.nullable,
        superType,
        header.classifierType,
        header.swiftName
    )
}

fun String.parseMainType(): String {
    /**
     * Ignoring categories
     * ```
     * SharedBase (SharedBaseCopying) <NSCopying>
     * ```
     * Would return `SharedBase`
     */
    return parseTokenGraph(this).first().name
}