package org.jetbrains.objcdiff.utils

inline fun <T, R> List<T>.foldIndexedSkippable(
    initial: R,
    block: (index: FoldIndex<T>, acc: R, element: T, skipNext: (n: Int) -> Unit) -> R
): R {
    var accumulator = initial
    var index = 0
    while (index < this.size) {
        var skipCount = 0
        val skip = { n: Int -> skipCount += n.coerceAtLeast(0) }

        accumulator = block(
            FoldIndex(index, this.size - 1 == index, this),
            accumulator,
            this[index],
            skip
        )
        index += skipCount + 1
    }
    return accumulator
}

data class FoldIndex<T>(
    var value: Int,
    val isLast: Boolean,
    val items: List<T>
) {
    fun getNextOrNull(): T? {
        return items.getOrNull(++value)
    }
}