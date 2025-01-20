package and.degilevich.dream.shared.foundation.primitive.primitives.number.float

import and.degilevich.dream.shared.foundation.primitive.primitives.PrimitivesExtConst.HUNDRED
import and.degilevich.dream.shared.foundation.primitive.primitives.number.double.format
import and.degilevich.dream.shared.foundation.primitive.primitives.number.format.NumberFormatScope

fun Float?.orZero(): Float {
    return this ?: 0f
}

fun Float.inHalf(): Float {
    return this / 2f
}

fun Float.hundredfold(): Float {
    return (this * HUNDRED)
}

fun Float.format(block: NumberFormatScope.() -> Unit): String {
    return this.toDouble().format(block)
}