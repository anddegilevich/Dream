package and.degilevich.dream.shared.foundation.datetime.api.localDateTime

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeFormat
import and.degilevich.dream.shared.foundation.datetime.impl.common.TimeUnit
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
internal interface LocalDateTimeWrapper {
    fun localDateTimeByInstantResult(
        instant: Instant,
        timeZone: TimeZone
    ): Result<LocalDateTime>

    fun localDateTimeByInstant(
        instant: Instant,
        timeZone: TimeZone
    ): LocalDateTime

    fun formatLocalDateTimeToStringResult(
        localDateTime: LocalDateTime,
        formatTo: DateTimeFormat,
        localeCode: String
    ): Result<String>

    fun formatLocalDateTimeToString(
        localDateTime: LocalDateTime,
        formatTo: DateTimeFormat,
        localeCode: String
    ): String

    fun instantToLocalDateTimeResult(
        instant: Instant,
        convertToLocal: Boolean
    ): Result<LocalDateTime>

    fun instantToLocalDateTime(
        instant: Instant,
        convertToLocal: Boolean
    ): LocalDateTime
    fun startLocalDateTime(
        localDateTime: LocalDateTime,
        unit: TimeUnit
    ): LocalDateTime
    fun endLocalDateTime(
        localDateTime: LocalDateTime,
        unit: TimeUnit
    ): LocalDateTime
}