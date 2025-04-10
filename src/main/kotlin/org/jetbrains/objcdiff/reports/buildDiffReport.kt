package org.jetbrains.objcdiff.reports

import org.jetbrains.objcdiff.DiffContext
import org.jetbrains.objcdiff.MemberEquality
import org.jetbrains.objcdiff.ObjCType

context(DiffContext)
fun buildDiffReport(expectedReport: HeaderReport, actualReport: HeaderReport): DiffReport {

    val expected = (expectedReport.types).associateBy { it.key }.toMutableMap()
    val actual = (actualReport.types).associateBy { it.key }.toMutableMap()
    val result = mutableMapOf<String, ObjCType>()

    verifyExpectedButNotDefined(actual, expected, result)
    verifyDefinedButNotExpected(actual, result)
    verifyMembers(actualReport.allSymbolsMap, expectedReport.allSymbolsMap)
    verifyMembersOrder(actualReport.allSymbolsMap, expectedReport.allSymbolsMap)
    verifyAllOk(actualReport.allSymbolsMap, expectedReport.allSymbolsMap)

    val definedButNotExpected = mutableSetOf<String>()
    val expectedButNotDefined = mutableSetOf<String>()
    val unequalMembers = mutableSetOf<String>()
    val invalidOrderTypes = mutableSetOf<String>()

    (actual + expected).forEach { (key, symbol) ->
        if (symbol.expectedButNotDefined == true) expectedButNotDefined.add(key)
        if (symbol.definedButNotExpected == true) definedButNotExpected.add(key)
        if (symbol.membersEquality != setOf(MemberEquality.EQUAL)) unequalMembers.add(key)
        if (symbol.membersEquality.contains(MemberEquality.INVALID_ORDER)) invalidOrderTypes.add(key)
    }

    return DiffReport(
        expectedButNotDefined = expectedButNotDefined,
        definedButNotExpected = definedButNotExpected,
        unequalMembers = unequalMembers,
        invalidOrderTypes = invalidOrderTypes,
        merge = result.values.toList()
    )
}

private fun verifyMembers(
    actual: Map<String, ObjCType>,
    expected: Map<String, ObjCType>
) {
    val notEqual = actual.keys.intersect(expected.keys).filter { key ->
        actual[key]?.members != expected[key]?.members
    }.toSet()

    notEqual.forEach { key ->
        actual[key]?.addMemberEquality(MemberEquality.UNEQUAL)
        expected[key]?.addMemberEquality(MemberEquality.UNEQUAL)
    }
}

private fun verifyAllOk(
    actual: Map<String, ObjCType>,
    expected: Map<String, ObjCType>
) {
    (actual + expected).forEach { (_, symbol) ->
        if (symbol.definedButNotExpected == null && symbol.expectedButNotDefined == null && symbol.membersEquality == setOf(
                MemberEquality.EQUAL
            )
        ) {
            symbol.allOk = true
        }
    }
}

private fun verifyDefinedButNotExpected(
    actual: Map<String, ObjCType>,
    result: MutableMap<String, ObjCType>
) {
    actual.forEach { (key, actualClassOrInterface) ->
        actualClassOrInterface.definedButNotExpected = true
        result[key] = actualClassOrInterface
    }
}

private fun verifyExpectedButNotDefined(
    actual: MutableMap<String, ObjCType>,
    expected: MutableMap<String, ObjCType>,
    result: MutableMap<String, ObjCType>
) {
    expected.forEach { (key, expectedClassOrInterface) ->
        result[key] = expectedClassOrInterface
        if (!actual.containsKey(key)) {
            expectedClassOrInterface.expectedButNotDefined = true
        } else {
            actual.remove(key)
        }
    }
}

fun verifyMembersOrder(
    actual: Map<String, ObjCType>,
    expected: Map<String, ObjCType>
) {
    actual.forEach { (key, actualType) ->
        val expectedType = expected[key]
        if (expectedType != null) {
            if (!verifyMembersOrder(actualType, expectedType)) {
                actualType.addMemberEquality(MemberEquality.INVALID_ORDER)
                expectedType.addMemberEquality(MemberEquality.INVALID_ORDER)
            }
        }
    }
}

fun verifyMembersOrder(
    actualType: ObjCType,
    expectedType: ObjCType
): Boolean {

    val actualMembers = actualType.members.map { it.key }
    val expectedMembers = expectedType.members.map { it.key }

    if (actualMembers.isEmpty() && expectedMembers.isEmpty()) return true
    if (actualMembers.isEmpty()) return true
    if (expectedMembers.isEmpty()) return true

    var a = 0
    var e = 0
    var actual = actualMembers.getOrNull(a)
    var expected = actualMembers.getOrNull(e)
    while (actual != null && expected != null) {
        if (actual != expected) return false
        a++
        e++
        actual = actualMembers.getOrNull(a)
        expected = expectedMembers.getOrNull(a)
    }

    return true
}