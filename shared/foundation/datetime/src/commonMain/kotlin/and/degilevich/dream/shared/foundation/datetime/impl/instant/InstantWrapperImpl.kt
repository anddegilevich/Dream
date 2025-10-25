package and.degilevich.dream.shared.foundation.datetime.impl.instant

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeFormat
import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput
import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeSource
import and.degilevich.dream.shared.foundation.datetime.api.instant.InstantWrapper
import and.degilevich.dream.shared.foundation.datetime.api.logger.DateTimeLogger
import and.degilevich.dream.shared.foundation.datetime.api.platform.PlatformDateFormatter
import and.degilevich.dream.shared.foundation.datetime.api.unit.TimeUnitToDateTimeUnitMapper
import and.degilevich.dream.shared.foundation.datetime.impl.common.TimeUnit
import and.degilevich.dream.shared.foundation.primitive.result.foldResult
import kotlin.time.Clock
import kotlinx.datetime.DateTimeArithmeticException
import kotlin.time.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.minus
import kotlinx.datetime.plus
import kotlin.math.abs
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
internal class InstantWrapperImpl(
    private val logger: DateTimeLogger,
    private val platformDateFormatter: PlatformDateFormatter,
    private val timeUnitMapper: TimeUnitToDateTimeUnitMapper
) : InstantWrapper {

    override fun currentInstant(): Instant {
        logger.logInfo("InstantWrapperImpl.currentInstant -> invoke")
        val instant = Clock.System.now()
        logger.logInfo("InstantWrapperImpl.currentInstant success -> instant:$instant")
        return instant
    }

    override fun timeInstantResult(input: DateTimeInput): Result<Instant> {
        return when (val source = input.source) {
            is DateTimeSource.FromMillis -> Result.success(instantFromEpochMilliseconds(source.millis))
            is DateTimeSource.FromString -> instantFromDateResult(date = source.date, format = source.format)
        }
    }

    override fun instantWithOffsetResult(
        instant: Instant,
        offset: Int,
        offsetUnit: TimeUnit
    ): Result<Instant> {
        logger.logInfo(
            buildString {
                append("InstantWrapperImpl.instantWithOffsetResult -> invoke")
                append(" | ")
                append("instant:$instant | offset:$offset | offsetUnit:$offsetUnit")
            }
        )
        return try {
            val timeUnit = timeUnitMapper.map(offsetUnit)
            val formattedInstant = if (offset >= 0) {
                instant.plus(
                    value = offset,
                    unit = timeUnit,
                    timeZone = TimeZone.UTC
                )
            } else {
                instant.minus(
                    value = abs(offset),
                    unit = timeUnit,
                    timeZone = TimeZone.UTC
                )
            }
            logger.logInfo("InstantWrapperImpl.instantWithOffsetResult -> success | instant:$formattedInstant")
            Result.success(formattedInstant)
        } catch (e: DateTimeArithmeticException) {
            logger.logError(e)
            Result.failure(e)
        }
    }

    override fun instantFromEpochMilliseconds(milliseconds: Long): Instant {
        logger.logInfo("InstantWrapperImpl.instantFromEpochMilliseconds -> invoke | milliseconds:$milliseconds")
        val instant = Instant.fromEpochMilliseconds(milliseconds)
        logger.logInfo("InstantWrapperImpl.instantFromEpochMilliseconds -> success | instant:$instant")
        return instant
    }

    override fun parseInstantResult(date: String): Result<Instant> {
        return try {
            logger.logInfo("InstantWrapperImpl.parseInstantResult -> invoke | date:$date")
            val instant = Instant.parse(date)
            logger.logInfo("InstantWrapperImpl.parseInstantResult -> success | instant:$instant")
            Result.success(instant)
        } catch (e: IllegalArgumentException) {
            logger.logError(e)
            Result.failure(e)
        }
    }

    override fun instantFromDateResult(
        date: String,
        format: DateTimeFormat
    ): Result<Instant> {
        return try {
            platformDateFormatter.toDateFormatResult(
                date = date,
                formatFrom = format,
                formatTo = DateTimeFormat.Defaults.ISO_8601
            ).foldResult { platformFormattedDate ->
                parseInstantResult(platformFormattedDate).foldResult { parseInstant ->
                    Result.success(parseInstant)
                }
            }
        } catch (e: IllegalArgumentException) {
            logger.logError(e)
            return Result.failure(e)
        }
    }
}