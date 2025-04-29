package org.jetbrains.objcdiff.reports

import org.jetbrains.objcdiff.*
import kotlin.reflect.KTypeProjection

data class NamespacePrefix(val namespace: String, val prefix: String)

context(ObjCContext)
fun List<ObjCType>.toClassDiagramMermaid(namespaces: List<NamespacePrefix> = emptyList()): String {

    val sb = StringBuilder()
    val references = mutableSetOf<String>()
    val allPrefixes = namespaces.map { namespace -> namespace.prefix }

    sb.appendLine("```mermaid")
    sb.appendLine("classDiagram")

    if (namespaces.isEmpty()) {
        buildClasses(sb, references)
    } else {

        val namespacedSymbols = mutableMapOf<NamespacePrefix, MutableList<ObjCType>>()
        val otherSymbols = mutableListOf<ObjCType>()

        namespaces.forEach { namespacedSymbols[it] = mutableListOf() }

        forEach { symbol ->
            var foundNamespace = false
            namespaces.forEach { namespacePrefix ->
                if (symbol.name.startsWith(namespacePrefix.prefix)) {
                    foundNamespace = true
                    namespacedSymbols[namespacePrefix]?.add(symbol)
                }
            }

            if (!foundNamespace) {
                otherSymbols.add(symbol)
            }
        }

        namespacedSymbols.forEach { (namespace, symbols) ->
            symbols.buildClasses(sb, references, namespace.namespace, allPrefixes)
        }
    }

    references.forEach { reference ->
        sb.appendLine(reference)
    }

    //define colors
    forEach { symbol ->

        val color = when {
            symbol.expectedButNotDefined == true -> Colors.EXPECTED_BUT_NOT_DEFINED
            symbol.definedButNotExpected == true -> Colors.DEFINED_BUT_NOT_EXPECTED
            symbol.membersEquality != setOf(MemberEquality.EQUAL) -> Colors.MEMBERS_DO_NOT_MATCH
            symbol.membersEquality.contains(MemberEquality.INVALID_ORDER) -> Colors.MEMBERS_ORDER
            symbol.allOk == true -> Colors.OK
            else -> null
        }

        if (color != null) sb.appendLine("style ${symbol.name} fill: $color")
    }

    sb.appendLine("```")
    return sb.toString()
}


object Colors {
    const val EXPECTED_BUT_NOT_DEFINED = "#FF0000"
    const val DEFINED_BUT_NOT_EXPECTED = "#007bff"
    const val MEMBERS_DO_NOT_MATCH = "#e3a300"
    const val MEMBERS_ORDER = "#99a300"
    const val OK = "#37a600"
}

context(ObjCContext)
private fun List<ObjCType>.buildClasses(
    sb: StringBuilder,
    references: MutableSet<String>,
    namespace: String = "",
    removePrefix: List<String> = emptyList()
) {
    val namespaceSb = StringBuilder()

    fun withoutPrefix(name: String): String {

        removePrefix.forEach {
            if (name.startsWith(it)) {
                return name.replace(it, "")
            }
        }

        return name
    }

    fun referenceType(from: String, to: ObjCType?, refType: ObjCReferenceType) {

        if (to == null) return
        if (from.isIgnoredType) return
        val targetType = withoutPrefix(to.name)
        if (targetType.isIgnoredType) return

        val refName = when (refType) {
            ObjCReferenceType.SUPER -> "super"
            ObjCReferenceType.PROPERTY -> "property"
            ObjCReferenceType.METHOD_PARAM -> "method-param"
            ObjCReferenceType.METHOD_RETURN -> "method-return"
            ObjCReferenceType.GENERIC -> "generic"
        }

        if (skipRefType) {
            references.add("$from --> $targetType")
        } else {
            references.add("$from --> $targetType : $refName")
        }

        if (to is ObjCType.ObjectType) {
            to.generics.forEach { generic ->
                referenceType(from, generic, ObjCReferenceType.GENERIC)
            }
        }
    }

    forEach { symbol ->
        val symbolTypeName = withoutPrefix(symbol.name)
        var generics = emptyList<ObjCType>()
        var members = emptyList<ObjCMember>()
        var superType: ObjCType? = null

        if(symbol is ObjCType.ObjectType) {
            generics = symbol.generics
            members = symbol.members
            superType = symbol.superType
        }

        generics.forEach { referenceType(symbolTypeName, it, ObjCReferenceType.GENERIC) }
        referenceType(symbolTypeName, superType, ObjCReferenceType.SUPER)

        if (members.isNotEmpty()) {
            namespaceSb.appendLine("class $symbolTypeName {")
            val membersSb = StringBuilder()
            members.forEach { member ->

                if (member is ObjCMethod) {
                    membersSb.appendLine(
                        " ${withoutPrefix(member.returnTypeName)} ${member.name}(${
                            member.arguments.joinToString(
                                ", "
                            ) { withoutPrefix(it.type.name) }
                        })")


                } else if (member is ObjCProperty) {
                    membersSb.appendLine(" ${withoutPrefix(member.returnTypeName)} ${member.name}")
                }
            }
            namespaceSb.appendLine(membersSb)
            namespaceSb.appendLine("}")
        } else {
            namespaceSb.appendLine("class $symbolTypeName")
        }

        members.forEach { member ->

            val kTypeProjection: KTypeProjection.Companion? = null
            kTypeProjection?.STAR

            if (member is ObjCMethod) {
                if (member.returnType != null) referenceType(
                    symbolTypeName,
                    member.returnType,
                    ObjCReferenceType.METHOD_RETURN
                )
                member.arguments.forEach { param ->
                    referenceType(symbolTypeName, param.type, ObjCReferenceType.METHOD_PARAM)
                }
            } else if (member is ObjCProperty) {
                referenceType(symbolTypeName, member.type, ObjCReferenceType.PROPERTY)
            }
        }
    }

    if (namespaceSb.isNotEmpty()) {

        if (namespace.isEmpty()) {
            sb.append(namespaceSb)
        } else {
            sb.appendLine("namespace $namespace {")
            sb.append(namespaceSb)
            sb.appendLine("}")
        }

    }
}

val ObjCMember.returnTypeName: String
    get() {
        return when (this) {
            is ObjCProperty -> {
                this.type.name
            }

            is ObjCMethod -> {
                this.returnType?.name ?: "Void"
            }

            else -> {
                "UnsupportedMemberReturnType"
            }
        }
    }
