package and.degilevich.dream.shared.foundation.datetime.impl.between

import and.degilevich.dream.shared.foundation.datetime.api.between.TimeBetweenDatesConfigBuilder
import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput
import and.degilevich.dream.shared.foundation.datetime.impl.common.TimeUnit

internal class TimeBetweenDatesConfigBuilderImpl : TimeBetweenDatesConfigBuilder {

    private var startInputMutable: DateTimeInput? = null
    private var endInputMutable: DateTimeInput? = null
    private var unitMutable: TimeUnit? = null

    override fun setStartInput(value: DateTimeInput) {
        startInputMutable = value
    }

    override fun setEndInput(value: DateTimeInput) {
        endInputMutable = value
    }

    override fun setUnit(value: TimeUnit) {
        unitMutable = value
    }

    override fun build(): Result<TimeBetweenDatesConfig> {
        val startInput = startInputMutable
        val endInput = endInputMutable
        val unit = unitMutable

        return when {
            startInput == null || startInput.isEmpty() -> {
                Result.failure(Exception("TimeBetweenDatesConfigBuilderImpl.build startInput is null or empty"))
            }

            endInput == null || endInput.isEmpty() -> {
                Result.failure(Exception("TimeBetweenDatesConfigBuilderImpl.build endInput is null or empty"))
            }

            unit == null -> {
                Result.failure(Exception("TimeBetweenDatesConfigBuilderImpl.build unit is null"))
            }

            else -> Result.success(
                TimeBetweenDatesConfig(
                    startInput = startInput,
                    endInput = endInput,
                    unit = unit
                )
            )
        }
    }
}