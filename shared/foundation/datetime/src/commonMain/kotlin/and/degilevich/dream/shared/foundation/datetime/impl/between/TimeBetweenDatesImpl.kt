package and.degilevich.dream.shared.foundation.datetime.impl.between

import and.degilevich.dream.shared.foundation.datetime.api.between.TimeBetweenDates
import and.degilevich.dream.shared.foundation.datetime.api.between.TimeBetweenDatesConfigBuilderScope
import and.degilevich.dream.shared.foundation.datetime.api.between.TimeBetweenNowAndDateConfigBuilderScope
import and.degilevich.dream.shared.foundation.datetime.api.instant.InstantWrapper
import and.degilevich.dream.shared.foundation.datetime.api.instantLocalDateTime.InstantLocalDateTime
import and.degilevich.dream.shared.foundation.datetime.api.localDateTime.LocalDateTimeWrapper
import and.degilevich.dream.shared.foundation.datetime.api.timezone.TimeZoneWrapper
import and.degilevich.dream.shared.foundation.datetime.impl.common.TimeUnit
import and.degilevich.dream.shared.foundation.datetime.impl.instant.InstantLocalDateTimeOutput
import and.degilevich.dream.shared.foundation.primitive.result.foldResult
import kotlinx.datetime.number
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
internal class TimeBetweenDatesImpl(
    private val instant: InstantWrapper,
    private val localDateTime: LocalDateTimeWrapper,
    private val instantLocalDateTime: InstantLocalDateTime,
    private val timeZone: TimeZoneWrapper
) : TimeBetweenDates {

    private fun betweenValue(
        start: InstantLocalDateTimeOutput,
        end: InstantLocalDateTimeOutput,
        unit: TimeUnit
    ): Result<Long> {
        val startInstant = start.instant
        val endInstant = end.instant
        val startLocalDateTime = start.localDateTime
        val endLocalDateTime = end.localDateTime
        val duration = endInstant - startInstant
        val yearDiffs = endLocalDateTime.year - startLocalDateTime.year
        val value = when (unit) {
            TimeUnit.MILLISECOND -> duration.inWholeMilliseconds
            TimeUnit.SECOND -> duration.inWholeSeconds
            TimeUnit.MINUTE -> duration.inWholeMinutes
            TimeUnit.HOUR -> duration.inWholeHours
            TimeUnit.DAY -> duration.inWholeDays
            TimeUnit.MONTH -> {
                yearDiffs * MONTHS_IN_YEAR + (endLocalDateTime.month.number - startLocalDateTime.month.number)
            }

            TimeUnit.YEAR -> yearDiffs
        }
        return Result.success(value.toLong())
    }

    override fun timeBetweenNowAndDateResult(block: TimeBetweenNowAndDateConfigBuilderScope.() -> Unit): Result<Long> {
        return TimeBetweenNowAndDateConfigBuilderImpl().apply(block).build().foldResult { config ->
            val currentInstant = instant.currentInstant()
            val timeZone = timeZone.timeZoneByLocal(config.convertToLocal)
            instant.timeInstantResult(config.input).foldResult { instantByInput ->
                localDateTime.localDateTimeByInstantResult(
                    instant = instantByInput,
                    timeZone = timeZone
                ).foldResult { inputLocalDateTime ->
                    localDateTime.localDateTimeByInstantResult(
                        instant = currentInstant,
                        timeZone = timeZone
                    ).foldResult { currentLocalDateTime ->
                        betweenValue(
                            start = InstantLocalDateTimeOutput(
                                instant = currentInstant,
                                localDateTime = currentLocalDateTime
                            ),
                            end = InstantLocalDateTimeOutput(
                                instant = instantByInput,
                                localDateTime = inputLocalDateTime
                            ),
                            unit = config.unit
                        )
                    }
                }
            }
        }
    }

    override fun timeBetweenNowAndDate(block: TimeBetweenNowAndDateConfigBuilderScope.() -> Unit): Long {
        return timeBetweenNowAndDateResult(block).getOrNull() ?: INVALID_VALUE
    }

    override fun timeBetweenDatesResult(block: TimeBetweenDatesConfigBuilderScope.() -> Unit): Result<Long> {
        return TimeBetweenDatesConfigBuilderImpl().apply(block).build().foldResult { config ->
            instantLocalDateTime.instantLocalDateTimeOutputResult(
                input = config.startInput,
                convertToLocal = false
            ).foldResult { start ->
                instantLocalDateTime.instantLocalDateTimeOutputResult(
                    input = config.endInput,
                    convertToLocal = false
                ).foldResult { end ->
                    betweenValue(
                        start = start,
                        end = end,
                        unit = config.unit
                    )
                }
            }
        }
    }

    override fun timeBetweenDates(block: TimeBetweenDatesConfigBuilderScope.() -> Unit): Long {
        return timeBetweenDatesResult(block).getOrNull() ?: INVALID_VALUE
    }

    private companion object {
        const val INVALID_VALUE = 0L
        const val MONTHS_IN_YEAR = 12
    }
}