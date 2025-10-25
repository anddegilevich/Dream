package and.degilevich.dream.shared.foundation.datetime.impl.localDateTime

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeFormat
import and.degilevich.dream.shared.foundation.datetime.api.localDateTime.LocalDateTimeWrapper
import and.degilevich.dream.shared.foundation.datetime.api.logger.DateTimeLogger
import and.degilevich.dream.shared.foundation.datetime.api.platform.PlatformDateFormatter
import and.degilevich.dream.shared.foundation.datetime.api.timezone.TimeZoneWrapper
import and.degilevich.dream.shared.foundation.datetime.impl.common.TimeUnit
import and.degilevich.dream.shared.foundation.datetime.impl.common.ext.buildEndByDay
import and.degilevich.dream.shared.foundation.datetime.impl.common.ext.buildEndByHour
import and.degilevich.dream.shared.foundation.datetime.impl.common.ext.buildEndByMinute
import and.degilevich.dream.shared.foundation.datetime.impl.common.ext.buildEndByMonth
import and.degilevich.dream.shared.foundation.datetime.impl.common.ext.buildEndByNanosecond
import and.degilevich.dream.shared.foundation.datetime.impl.common.ext.buildEndByYear
import and.degilevich.dream.shared.foundation.datetime.impl.common.ext.buildStartByDay
import and.degilevich.dream.shared.foundation.datetime.impl.common.ext.buildStartByHour
import and.degilevich.dream.shared.foundation.datetime.impl.common.ext.buildStartByMinute
import and.degilevich.dream.shared.foundation.datetime.impl.common.ext.buildStartByMonth
import and.degilevich.dream.shared.foundation.datetime.impl.common.ext.buildStartByNanoseconds
import and.degilevich.dream.shared.foundation.datetime.impl.common.ext.buildStartByYear
import and.degilevich.dream.shared.foundation.datetime.impl.common.ext.formatToIso8601
import and.degilevich.dream.shared.foundation.datetime.impl.common.ext.startUnixLocalDateTime
import kotlinx.datetime.DateTimeArithmeticException
import kotlinx.datetime.LocalDateTime
import kotlin.time.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
internal class LocalDateTimeWrapperImpl(
    private val logger: DateTimeLogger,
    private val timeZone: TimeZoneWrapper,
    private val platformFormatter: PlatformDateFormatter
) : LocalDateTimeWrapper {

    override fun localDateTimeByInstantResult(
        instant: Instant,
        timeZone: TimeZone
    ): Result<LocalDateTime> {
        return try {
            logger.logInfo(
                buildString {
                    append("LocalDateTimeWrapperImpl.localDateTimeByInstantResult -> invoke")
                    append(" | ")
                    append("instant:$instant | timeZone:$timeZone")
                }
            )
            val localDateTime = instant.toLocalDateTime(timeZone)
            logger.logInfo(
                buildString {
                    append("LocalDateTimeWrapperImpl.localDateTimeByInstantResult -> success")
                    append(" | ")
                    append("localDateTime:$localDateTime")
                }
            )
            Result.success(localDateTime)
        } catch (e: DateTimeArithmeticException) {
            logger.logError(e)
            Result.failure(e)
        }
    }

    override fun localDateTimeByInstant(instant: Instant, timeZone: TimeZone): LocalDateTime {
        return localDateTimeByInstantResult(instant, timeZone).getOrNull() ?: startUnixLocalDateTime()
    }

    override fun formatLocalDateTimeToStringResult(
        localDateTime: LocalDateTime,
        formatTo: DateTimeFormat,
        localeCode: String
    ): Result<String> {
        return platformFormatter.toDateFormatResult(
            date = localDateTime.formatToIso8601(),
            formatFrom = DateTimeFormat.Defaults.ISO_8601,
            formatTo = formatTo
        )
    }

    override fun formatLocalDateTimeToString(
        localDateTime: LocalDateTime,
        formatTo: DateTimeFormat,
        localeCode: String
    ): String {
        return formatLocalDateTimeToStringResult(
            localDateTime = localDateTime,
            formatTo = formatTo,
            localeCode = localeCode
        ).getOrNull().orEmpty()
    }

    override fun instantToLocalDateTimeResult(instant: Instant, convertToLocal: Boolean): Result<LocalDateTime> {
        return localDateTimeByInstantResult(
            instant = instant,
            timeZone = timeZone.timeZoneByLocal(convertToLocal)
        )
    }

    override fun instantToLocalDateTime(instant: Instant, convertToLocal: Boolean): LocalDateTime {
        return instantToLocalDateTimeResult(
            instant = instant,
            convertToLocal = convertToLocal
        ).getOrNull() ?: startUnixLocalDateTime()
    }

    override fun startLocalDateTime(
        localDateTime: LocalDateTime,
        unit: TimeUnit
    ): LocalDateTime {
        return when (unit) {
            TimeUnit.MILLISECOND,
            TimeUnit.SECOND -> localDateTime.buildStartByNanoseconds()

            TimeUnit.MINUTE -> localDateTime.buildStartByMinute()
            TimeUnit.HOUR -> localDateTime.buildStartByHour()
            TimeUnit.DAY -> localDateTime.buildStartByDay()
            TimeUnit.MONTH -> localDateTime.buildStartByMonth()
            TimeUnit.YEAR -> localDateTime.buildStartByYear()
        }
    }

    override fun endLocalDateTime(
        localDateTime: LocalDateTime,
        unit: TimeUnit
    ): LocalDateTime {
        return when (unit) {
            TimeUnit.MILLISECOND,
            TimeUnit.SECOND -> localDateTime.buildEndByNanosecond()

            TimeUnit.MINUTE -> localDateTime.buildEndByMinute()
            TimeUnit.HOUR -> localDateTime.buildEndByHour()
            TimeUnit.DAY -> localDateTime.buildEndByDay()
            TimeUnit.MONTH -> localDateTime.buildEndByMonth()
            TimeUnit.YEAR -> localDateTime.buildEndByYear()
        }
    }
}
