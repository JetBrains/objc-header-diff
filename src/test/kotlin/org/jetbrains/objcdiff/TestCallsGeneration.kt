package org.jetbrains.objcdiff

import org.jetbrains.objcdiff.reports.*
import kotlin.test.Test

class TestCallsGeneration {
    @Test
    fun temp() {
        val fileName = "datetime_with_klibapi.h"
        val resource = javaClass.classLoader.getResource(fileName)
        val content = resource?.readText() ?: error("Can't read '$fileName'")
        with(ObjCContext()) {

            val objc = content.lineSequence()
                .skipEmpty()
                .skipGroup(startComment, endComment)
                .skipForwardProtocols()
                .toObjCTypes()
                .toList()

            //val objc = content.parseObjCObjects()
            println(objc)
        }
    }

    @Test
    fun `temp - share klib api`() {
        val fileName = "datetime_with_klibapi.h"
        val resource = javaClass.classLoader.getResource(fileName)
        val content = resource?.readText() ?: error("Can't read '$fileName'")
        with(ObjCContext()) {

            val types = content.lineSequence()
                .skipEmpty()
                .skipGroup(startComment, endComment)
                .skipForwardProtocols()
                .toObjCTypes()
                .toList()

            val klibApi = types.first { it is ObjCType.ObjectType && it.swiftName == "KlibApiKt" }

            //val objc = content.parseObjCObjects()
            val s = buildSwiftApiCall(klibApi, types.associateBy { it.name })
            println(s)
        }
    }
}

fun buildSwiftApiCall(type: ObjCType.ObjectType, allTypesMap: Map<String, ObjCType.ObjectType>): String {
    val className = type.swiftName

    val sb = StringBuilder()

    type.members.forEach { member ->
        if (member is ObjCMethod) {
            val returnType = member.returnType

            val instanceName = if (returnType is ObjCType.ObjectType) {
                returnType.swiftName ?: returnType.name
            } else {
                returnType?.name ?: error("No return type for $member")
            }

            if (instanceName == "id") {
                //skip generics for now
            } else {
                sb.appendLine(
                    "let " + instanceName + " = $className." + member.swiftName + "()"
                )

                buildCalls(instanceName, allTypesMap[instanceName])?.let {
                    sb.append(it)
                }

                sb.appendLine()

                //build method calls
            }
        }
    }

    return sb.toString()
}

fun buildCalls(instanceName: String, type: ObjCType.ObjectType?): String? {
    if (type == null) return null
    val sb = StringBuilder()

    type.members.forEach { member ->
        if (member is ObjCMethod) {
            val swiftName = member.swiftName
            if (!member.isStatic && !member.isConstructor && swiftName != "hash" && swiftName != "isEqual") {

                val args = if (member.arguments.isEmpty()) {
                    ""
                } else {
                    member.arguments.joinToString(", ") { arg ->

                        val argType = arg.type
                        val argTypeStr = if (argType is ObjCType.PrimitiveType) {
                            objCTypeToSwiftType(argType.name)
                        } else {
                            if (argType is ObjCType.ObjectType) {
                                argType.swiftName ?: argType.name
                            } else argType.name
                        }

                        arg.swiftNameOrName() + ": Some() as! " + argTypeStr
                    }
                }

                sb.appendLine("$instanceName.$swiftName($args)")
            }
        }

    }

    return sb.toString()
}

fun objCTypeToSwiftType(type: String): String {
    return when (type) {
        "int8_t" -> "Int8"
        "uint8_t" -> "UInt8"
        "int16_t" -> "Int16"
        "uint16_t" -> "UInt16"
        "int32_t" -> "Int32"
        "uint32_t" -> "UInt32"
        //"int64_t" -> "Int32"
        "int64_t" -> "Int64"
        "uint64_t" -> "UInt64"
        "float" -> "Float"
        "double" -> "Double"
        "BOOL" -> "Bool"
        "NSString" -> "String"
        "NSNumber" -> "NSNumber"
        "NSData" -> "Data"
        "NSArray" -> "Array"
        "NSDictionary" -> "Dictionary"
        "NSError" -> "Error"
        else -> error("Unknown Objective-C type: $type")
    }
}