//https://github.com/detekt/detekt/issues/7769
@file:Suppress("MatchingDeclarationName")

package and.degilevich.dream.shared.foundation.primitive.primitives.number.format.formatter

import and.degilevich.dream.shared.foundation.primitive.primitives.number.format.NumberFormatConfig
import platform.Foundation.NSNumber
import platform.Foundation.NSNumberFormatter

internal actual class DoubleFormatterImpl actual constructor(
    private val config: NumberFormatConfig,
) : DoubleFormatter {

    override fun format(double: Double): String {
        val number = NSNumber(double)
        val numberFormatter = NSNumberFormatter().apply {
            decimalSeparator = config.decimalSeparator.toString()
            config.fractionDigits.toULong().let { fractionDigits ->
                minimumFractionDigits = fractionDigits
                maximumFractionDigits = fractionDigits
            }
        }
        return numberFormatter.stringFromNumber(number).orEmpty()
    }
}