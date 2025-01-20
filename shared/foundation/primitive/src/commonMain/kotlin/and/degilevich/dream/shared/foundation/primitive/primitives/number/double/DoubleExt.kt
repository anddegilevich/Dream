package and.degilevich.dream.shared.foundation.primitive.primitives.number.double

import and.degilevich.dream.shared.foundation.primitive.primitives.PrimitivesExtConst.HUNDRED
import and.degilevich.dream.shared.foundation.primitive.primitives.number.format.NumberFormatConfigBuilder
import and.degilevich.dream.shared.foundation.primitive.primitives.number.format.NumberFormatScope
import and.degilevich.dream.shared.foundation.primitive.primitives.number.format.formatter.DoubleFormatter
import and.degilevich.dream.shared.foundation.primitive.primitives.number.format.formatter.DoubleFormatterImpl

fun Double?.orZero(): Double {
    return this ?: 0.0
}

fun Double.format(block: NumberFormatScope.() -> Unit = { }): String {
    val configBuilder: NumberFormatConfigBuilder = NumberFormatConfigBuilder.Base()
    val config = configBuilder.apply(block).build()
    val formatter: DoubleFormatter = DoubleFormatterImpl(config = config)
    return formatter.format(double = this)
}

fun Double.inHalf(): Double {
    return this / 2.0
}

fun Double.hundredfold(): Double {
    return (this * HUNDRED)
}