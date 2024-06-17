package org.example.org.jetbrains.objcdiff.reports

import org.example.org.jetbrains.objcdiff.ObjCClassOrInterface
import org.example.org.jetbrains.objcdiff.parsers.parseMembers
import org.example.org.jetbrains.objcdiff.parsers.parseSymbolTitle
import org.example.org.jetbrains.objcdiff.parsers.parseType
import org.example.org.jetbrains.objcdiff.utils.loadResourceFile

val startComment = "^/\\*\\*.*".toRegex()
val endComment = "\\*/".toRegex()

val startInterface = "@interface.*".toRegex()
val startProtocol = "@protocol.*".toRegex()
val end = "@end".toRegex()

fun buildHeaderReport(fileName: String): HeaderReport {
    val sequence = loadResourceFile(fileName)
        .lineSequence()
        .skipEmpty()
        .skipGroup(startComment, endComment)
        .skipForwardProtocols()

    val interfaces = sequence.takeGroupWithType(startInterface, end, "interface")
    val protocols = sequence.takeGroupWithType(startProtocol, end, "protocol")
    return HeaderReport(
        fileName = fileName,
        protocols = protocols.toList(),
        interfaces = interfaces.toList()
    )
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

fun Sequence<String>.takeGroupWithType(
    start: Regex,
    end: Regex,
    symbolType: String
) = sequence<ObjCClassOrInterface> {
    var take = false
    var key = ""
    var rawMainType = ""
    var rawSuperType: String? = null
    val members = mutableListOf<String>()
    for (str in this@takeGroupWithType) {
        when {
            str.matches(start) -> {

                val symbolTitle = str.parseSymbolTitle(symbolType)

                take = true
                members.clear()
                key = symbolTitle.rawMain
                rawMainType = symbolTitle.rawMain
                rawSuperType = symbolTitle.rawSuper
            }

            str.matches(end) && take -> {
                take = false
                yield(
                    ObjCClassOrInterface(
                        key = key,
                        type = rawMainType.parseType(),
                        superType = rawSuperType?.parseType(),
                        classOrInterface = symbolType,
                        members = members.parseMembers()
                    )
                )
            }

            take -> {
                members.add(str)
            }
        }
    }
}