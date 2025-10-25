package and.degilevich.dream.shared.foundation.datetime.impl.between

import and.degilevich.dream.shared.foundation.datetime.api.between.TimeBetweenNowAndDateConfigBuilder
import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput
import and.degilevich.dream.shared.foundation.datetime.impl.common.TimeUnit

internal class TimeBetweenNowAndDateConfigBuilderImpl : TimeBetweenNowAndDateConfigBuilder {

    private var inputMutable: DateTimeInput? = null
    private var convertToLocalMutable: Boolean = false
    private var unitMutable: TimeUnit? = null

    override fun setInput(input: DateTimeInput) {
        inputMutable = input
    }

    override fun setConvertToLocal(isConverted: Boolean) {
        convertToLocalMutable = isConverted
    }

    override fun setUnit(unit: TimeUnit) {
        unitMutable = unit
    }

    override fun build(): Result<TimeBetweenNowAndDateConfig> {
        val input = inputMutable
        val unit = unitMutable
        return when {
            input == null || input.isEmpty() -> Result.failure(
                Exception("TimeBetweenNowAndDateConfigBuilderImpl.build input is null or empty")
            )

            unit == null -> Result.failure(
                Exception("TimeBetweenNowAndDateConfigBuilderImpl.build unit is null")
            )

            else -> Result.success(
                TimeBetweenNowAndDateConfig(
                    input = input,
                    convertToLocal = convertToLocalMutable,
                    unit = unit
                )
            )
        }
    }
}