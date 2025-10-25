package and.degilevich.dream.shared.foundation.datetime.impl.verification

import and.degilevich.dream.shared.foundation.datetime.api.instant.InstantWrapper
import and.degilevich.dream.shared.foundation.datetime.api.localDateTime.LocalDateTimeWrapper
import and.degilevich.dream.shared.foundation.datetime.api.timezone.TimeZoneWrapper
import and.degilevich.dream.shared.foundation.datetime.api.verification.VerificationDateBuilderScope
import and.degilevich.dream.shared.foundation.datetime.api.verification.VerificationDateWithOffsetBuilderScope
import and.degilevich.dream.shared.foundation.primitive.result.foldResult
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.minus
import kotlinx.datetime.plus
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
internal class DateTimeVerificationImpl(
    val instant: InstantWrapper,
    val localDateTime: LocalDateTimeWrapper,
    val timeZone: TimeZoneWrapper
) : AbstractDateTimeVerification(
    instant = instant,
    timeZone = timeZone,
    localDateTime = localDateTime
) {

    override fun isFutureDateWithOffsetResult(
        block: VerificationDateWithOffsetBuilderScope.() -> Unit
    ): Result<Boolean> {
        return VerificationDateWithOffsetConfigBuilderImpl().apply(block).build().foldResult { config ->
            val currentInstant = instant.currentInstant()
            instant.timeInstantResult(config.input).foldResult { inputInstant ->
                val isFutureDate = (inputInstant - currentInstant) >= config.duration
                return Result.success(isFutureDate)
            }
        }
    }

    override fun isFutureDateWithOffset(
        block: VerificationDateWithOffsetBuilderScope.() -> Unit
    ): Boolean {
        return isFutureDateWithOffsetResult(block).getOrNull() ?: false
    }

    override fun isPastDateWithOffsetResult(
        block: VerificationDateWithOffsetBuilderScope.() -> Unit
    ): Result<Boolean> {
        return VerificationDateWithOffsetConfigBuilderImpl().apply(block).build().foldResult { config ->
            val currentInstant = instant.currentInstant()
            instant.timeInstantResult(config.input).foldResult { inputInstant ->
                val isPastDate = (currentInstant - inputInstant) >= config.duration
                return Result.success(isPastDate)
            }
        }
    }

    override fun isPastDateWithOffset(
        block: VerificationDateWithOffsetBuilderScope.() -> Unit
    ): Boolean {
        return isPastDateWithOffsetResult(block).getOrNull() ?: false
    }

    override fun isTodayResult(
        block: VerificationDateBuilderScope.() -> Unit
    ): Result<Boolean> {
        return VerificationDateConfigBuilderImpl().apply(block).build().foldResult { config ->
            currentTimeVerificationOutputResult(
                input = config.input,
                isConvertToLocal = config.isConvertToLocal
            ).foldResult { output ->
                val currentDate = output.currentDate
                val inputDate = output.inputDate
                val isSameYear = currentDate.year == inputDate.year
                val isSameMonth = currentDate.month == inputDate.month
                val isSameDay = currentDate.month == inputDate.month
                val isToday = isSameYear && isSameMonth && isSameDay
                Result.success(isToday)
            }
        }
    }

    override fun isToday(
        block: VerificationDateBuilderScope.() -> Unit
    ): Boolean {
        return isTodayResult(block).getOrNull() ?: false
    }

    override fun isYesterdayResult(
        block: VerificationDateBuilderScope.() -> Unit
    ): Result<Boolean> {
        return VerificationDateConfigBuilderImpl().apply(block).build().foldResult { config ->
            currentTimeVerificationOutputResult(
                input = config.input,
                isConvertToLocal = config.isConvertToLocal
            ).foldResult { output ->
                val currentDate = output.currentDate
                val inputDate = output.inputDate
                val yesterdayDate = currentDate.date.minus(1, DateTimeUnit.DAY)
                val isYesterday = yesterdayDate == inputDate.date
                Result.success(isYesterday)
            }
        }
    }

    override fun isYesterday(
        block: VerificationDateBuilderScope.() -> Unit
    ): Boolean {
        return isYesterdayResult(block).getOrNull() ?: false
    }

    override fun isTomorrowResult(
        block: VerificationDateBuilderScope.() -> Unit
    ): Result<Boolean> {
        return VerificationDateConfigBuilderImpl().apply(block).build().foldResult { config ->
            currentTimeVerificationOutputResult(
                input = config.input,
                isConvertToLocal = config.isConvertToLocal
            ).foldResult { output ->
                val currentDate = output.currentDate
                val inputDate = output.inputDate
                val tomorrowDate = currentDate.date.plus(1, DateTimeUnit.DAY)
                val isTomorrow = tomorrowDate == inputDate.date
                Result.success(isTomorrow)
            }
        }
    }

    override fun isTomorrow(
        block: VerificationDateBuilderScope.() -> Unit
    ): Boolean {
        return isTomorrowResult(block).getOrNull() ?: false
    }

    override fun isCurrentYearResult(
        block: VerificationDateBuilderScope.() -> Unit
    ): Result<Boolean> {
        return VerificationDateConfigBuilderImpl().apply(block).build().foldResult { config ->
            currentTimeVerificationOutputResult(
                input = config.input,
                isConvertToLocal = config.isConvertToLocal
            ).foldResult { output ->
                val currentDate = output.currentDate
                val inputDate = output.inputDate
                val isCurrentYear = currentDate.year == inputDate.year
                Result.success(isCurrentYear)
            }
        }
    }

    override fun isCurrentYear(
        block: VerificationDateBuilderScope.() -> Unit
    ): Boolean {
        return isCurrentYearResult(block).getOrNull() ?: false
    }
}