package and.degilevich.dream.shared.foundation.primitive.primitives.number.format

internal interface NumberFormatConfigBuilder : NumberFormatScope {
    fun build(): NumberFormatConfig

    class Base : NumberFormatConfigBuilder {

        private var fractionDigits: Int = 0
        private var decimalSeparator: Char = '.'

        override fun setFractionDigits(digits: Int) {
            fractionDigits = digits.coerceAtLeast(0)
        }

        override fun setDecimalSeparator(separator: Char) {
            decimalSeparator = separator
        }

        override fun build(): NumberFormatConfig {
            return NumberFormatConfig(
                fractionDigits = fractionDigits,
                decimalSeparator = decimalSeparator
            )
        }
    }
}