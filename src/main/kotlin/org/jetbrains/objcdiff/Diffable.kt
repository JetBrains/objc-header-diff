package org.jetbrains.objcdiff

abstract class Diffable {
    var expectedButNotDefined: Boolean? = null
    var definedButNotExpected: Boolean? = null
    val membersEquality: Set<MemberEquality> get() = _membersEquality
    var allOk: Boolean? = null

    abstract val key: String

    private val _membersEquality = mutableSetOf(MemberEquality.EQUAL)

    fun addMemberEquality(equality: MemberEquality) {
        if (_membersEquality.contains(MemberEquality.EQUAL) && equality == MemberEquality.UNEQUAL || equality == MemberEquality.INVALID_ORDER) {
            _membersEquality.remove(MemberEquality.EQUAL)
        }
        _membersEquality.add(equality)
    }
}

enum class MemberEquality {
    EQUAL,
    INVALID_ORDER,
    UNEQUAL
}