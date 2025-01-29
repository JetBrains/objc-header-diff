package org.jetbrains.objcdiff.reports

import org.jetbrains.objcdiff.DiffContext
import org.jetbrains.objcdiff.ObjCType
import org.jetbrains.objcdiff.reports.DiffReport
import org.jetbrains.objcdiff.reports.HeaderReport

context(DiffContext)
fun buildDiffReport(expectedReport: HeaderReport, actualReport: HeaderReport): DiffReport {

    val expected = (expectedReport.types).associateBy { it.key }.toMutableMap()
    val actual = (actualReport.types).associateBy { it.key }.toMutableMap()
    val result = mutableMapOf<String, ObjCType>()

    verifyExpectedButNotDefined(actual, expected, result)
    verifyDefinedButNotExpected(actual, result)
    verifyMembers(actualReport.allSymbolsMap, expectedReport.allSymbolsMap)
    verifyAllOk(actualReport.allSymbolsMap, expectedReport.allSymbolsMap)

    val definedButNotExpected = mutableSetOf<String>()
    val expectedButNotDefined = mutableSetOf<String>()
    val unequalMembers = mutableSetOf<String>()

    (actual + expected).forEach { (key, symbol) ->
        when {
            symbol.expectedButNotDefined == true -> expectedButNotDefined.add(key)
            symbol.definedButNotExpected == true -> definedButNotExpected.add(key)
            symbol.unequalMembers == true -> unequalMembers.add(key)
        }
    }

    return DiffReport(
        expectedButNotDefined = expectedButNotDefined,
        definedButNotExpected = definedButNotExpected,
        unequalMembers = unequalMembers,
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
        actual[key]?.unequalMembers = true
        expected[key]?.unequalMembers = true
    }
}

private fun verifyAllOk(
    actual: Map<String, ObjCType>,
    expected: Map<String, ObjCType>
) {
    (actual + expected).forEach { (_, symbol) ->
        if (symbol.definedButNotExpected == null && symbol.expectedButNotDefined == null && symbol.unequalMembers == null) {
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