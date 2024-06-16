package org.example.org.jetbrains.objcdiff.reports

import org.example.org.jetbrains.objcdiff.ObjCClassOrInterface

fun buildDiffReport(expectedReport: HeaderReport, actualReport: HeaderReport): DiffReport {


    val expected = (expectedReport.protocols + expectedReport.interfaces).associateBy { it.key }.toMutableMap()
    val actual = (actualReport.protocols + actualReport.interfaces).associateBy { it.key }.toMutableMap()
    val result = mutableMapOf<String, ObjCClassOrInterface>()

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
        expectedButNotDefined = expectedButNotDefined.size,
        definedButNotExpected = definedButNotExpected.size,
        unequalMembers = unequalMembers.size,
        merge = result.values.toList()
    )
}

private fun verifyMembers(
    actual: Map<String, ObjCClassOrInterface>,
    expected: Map<String, ObjCClassOrInterface>
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
    actual: Map<String, ObjCClassOrInterface>,
    expected: Map<String, ObjCClassOrInterface>
) {
    (actual + expected).forEach { (_, symbol) ->
        if (symbol.definedButNotExpected == null && symbol.expectedButNotDefined == null && symbol.unequalMembers == null) {
            symbol.allOk = true
        }
    }
}

private fun verifyDefinedButNotExpected(
    actual: Map<String, ObjCClassOrInterface>,
    result: MutableMap<String, ObjCClassOrInterface>
) {
    actual.forEach { (key, actualClassOrInterface) ->
        actualClassOrInterface.definedButNotExpected = true
        result[key] = actualClassOrInterface
    }
}

private fun verifyExpectedButNotDefined(
    actual: MutableMap<String, ObjCClassOrInterface>,
    expected: MutableMap<String, ObjCClassOrInterface>,
    result: MutableMap<String, ObjCClassOrInterface>
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