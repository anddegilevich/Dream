package and.degilevich.dream.shared.foundation.primitive.primitives.number.long

import and.degilevich.dream.shared.foundation.primitive.primitives.number.double.format
import and.degilevich.dream.shared.foundation.primitive.primitives.number.format.NumberFormatScope

fun Long?.orZero(): Long {
    return this ?: 0L
}

fun Long.isNegative(): Boolean {
    return this < 0L
}

fun Long.inHalf(): Long {
    return this / 2L
}

fun Long.format(block: NumberFormatScope.() -> Unit): String {
    return this.toDouble().format(block)
}