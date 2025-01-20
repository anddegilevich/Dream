package and.degilevich.dream.shared.foundation.primitive.primitives.number.int

import and.degilevich.dream.shared.foundation.primitive.primitives.number.double.format
import and.degilevich.dream.shared.foundation.primitive.primitives.number.format.NumberFormatScope

fun Int?.orZero(): Int {
    return this ?: 0
}

fun Int?.orNullIfZero(): Int? {
    return if (this == 0) null else this
}

fun Int?.orNullIfNegative(): Int? {
    return this?.let {
        if (it >= 0) this else null
    }
}

fun Int.orZeroIfNegative(): Int {
    return if (this >= 0) this else 0
}

fun Int.isEven(): Boolean {
    return this % 2 == 0
}

fun Int.isOdd(): Boolean {
    return !this.isEven()
}

fun Int.isNegative(): Boolean {
    return this < 0
}

fun Int.format(block: NumberFormatScope.() -> Unit): String {
    return this.toDouble().format(block)
}

fun Int.inHalf(): Int {
    return this / 2
}