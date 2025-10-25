package and.degilevich.dream.shared.foundation.datetime.impl.moment

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeFormat
import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput
import and.degilevich.dream.shared.foundation.datetime.api.moment.MomentConfigBuilder
import and.degilevich.dream.shared.foundation.datetime.impl.common.TimeUnit

internal class MomentConfigBuilderImpl : MomentConfigBuilder {
    private var inputMutable: DateTimeInput? = null
    private var convertedToLocalMutable: Boolean = false
    private var unitMutable: TimeUnit? = null
    private var outputFormatMutable: DateTimeFormat = DateTimeFormat.Defaults.ISO_8601

    override fun setInput(input: DateTimeInput) {
        inputMutable = input
    }

    override fun setConvertToLocal(isConverted: Boolean) {
        convertedToLocalMutable = isConverted
    }

    override fun setUnit(unit: TimeUnit) {
        unitMutable = unit
    }

    override fun setOutputFormat(format: DateTimeFormat) {
        outputFormatMutable = format
    }

    override fun build(): Result<MomentConfig> {
        val input = inputMutable
        val convertToLocal = convertedToLocalMutable
        val unit = unitMutable
        val outputFormat = outputFormatMutable
        return when {
            input == null || input.isEmpty() -> Result.failure(
                Exception("MomentConfigBuilderImpl.build input is null or empty")
            )

            unit == null -> Result.failure(
                Exception("MomentConfigBuilderImpl.build unit is null")
            )

            else -> Result.success(
                MomentConfig(
                    input = input,
                    convertToLocal = convertToLocal,
                    unit = unit,
                    outputFormat = outputFormat
                )
            )
        }
    }
}