package org.jetbrains.objcdiff

abstract class Diffable {
    var expectedButNotDefined: Boolean? = null
    var definedButNotExpected: Boolean? = null
    var unequalMembers: Boolean? = null
    var allOk: Boolean? = null

    open val key: String
        get() = ""
}