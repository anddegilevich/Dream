package and.degilevich.dream.shared.foundation.primitive.primitives.number.format.formatter

import and.degilevich.dream.shared.foundation.primitive.primitives.number.format.NumberFormatConfig
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

internal actual class DoubleFormatterImpl actual constructor(
    private val config: NumberFormatConfig
) : DoubleFormatter {
    override fun format(double: Double): String {
        val decimalFormat = DecimalFormat().apply {
            decimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.ENGLISH).apply {
                decimalSeparator = config.decimalSeparator
            }
            config.fractionDigits.let { fractionDigits ->
                maximumFractionDigits = fractionDigits
                minimumFractionDigits = fractionDigits
            }
        }
        return decimalFormat.format(double)
    }
}