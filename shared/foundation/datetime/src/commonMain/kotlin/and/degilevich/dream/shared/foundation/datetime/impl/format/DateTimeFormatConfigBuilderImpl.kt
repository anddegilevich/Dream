package and.degilevich.dream.shared.foundation.datetime.impl.format

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput
import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeFormat
import and.degilevich.dream.shared.foundation.datetime.api.format.DateTimeFormatConfigBuilder

internal class DateTimeFormatConfigBuilderImpl : DateTimeFormatConfigBuilder {
    private var input: DateTimeInput? = null
    private var outputFormat: DateTimeFormat = DateTimeFormat.Empty()
    private var convertToLocal: Boolean = false

    override fun setInput(input: DateTimeInput) {
        this.input = input
    }

    override fun setOutputFormat(format: DateTimeFormat) {
        outputFormat = format
    }

    override fun setConvertToLocal(isConverted: Boolean) {
        convertToLocal = isConverted
    }

    override fun build(): Result<DateTimeFormatConfig> {
        val inputValue = input
        val outputFormatValue = outputFormat
        val convertToLocalValue = convertToLocal
        return when {
            inputValue == null || inputValue.isEmpty() -> {
                Result.failure(InvalidDateTimeFormatConfigException("input is null or empty"))
            }

            outputFormatValue.isEmpty() -> {
                Result.failure(InvalidDateTimeFormatConfigException("outputFormat is empty"))
            }

            else -> Result.success(
                DateTimeFormatConfig(
                    input = inputValue,
                    output = outputFormatValue,
                    convertToLocal = convertToLocalValue
                )
            )
        }
    }
}