package and.degilevich.dream.shared.foundation.datetime.api.instant

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeFormat
import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput
import and.degilevich.dream.shared.foundation.datetime.impl.common.TimeUnit
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
internal interface InstantWrapper {
    fun currentInstant(): Instant
    fun timeInstantResult(input: DateTimeInput): Result<Instant>
    fun instantWithOffsetResult(
        instant: Instant,
        offset: Int = 0,
        offsetUnit: TimeUnit
    ): Result<Instant>
    fun instantFromEpochMilliseconds(milliseconds: Long): Instant
    fun instantFromDateResult(
        date: String,
        format: DateTimeFormat
    ): Result<Instant>
    fun parseInstantResult(date: String): Result<Instant>
}