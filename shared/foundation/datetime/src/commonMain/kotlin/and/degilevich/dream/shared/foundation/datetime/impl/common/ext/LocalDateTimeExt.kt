@file:Suppress("TooManyFunctions")

package and.degilevich.dream.shared.foundation.datetime.impl.common.ext

import and.degilevich.dream.shared.foundation.datetime.impl.common.ext.LocalDateTimeExtConst.CENTURY_DIVISOR
import and.degilevich.dream.shared.foundation.datetime.impl.common.ext.LocalDateTimeExtConst.DAYS_IN_FEBRUARY_COMMON_YEAR
import and.degilevich.dream.shared.foundation.datetime.impl.common.ext.LocalDateTimeExtConst.DAYS_IN_FEBRUARY_LEAP_YEAR
import and.degilevich.dream.shared.foundation.datetime.impl.common.ext.LocalDateTimeExtConst.DAYS_IN_LONG_MONTH
import and.degilevich.dream.shared.foundation.datetime.impl.common.ext.LocalDateTimeExtConst.DAYS_IN_SHORT_MONTH
import and.degilevich.dream.shared.foundation.datetime.impl.common.ext.LocalDateTimeExtConst.FOUR_HUNDRED_YEAR_DIVISOR
import and.degilevich.dream.shared.foundation.datetime.impl.common.ext.LocalDateTimeExtConst.LEAP_YEAR_DIVISOR
import and.degilevich.dream.shared.foundation.datetime.impl.common.ext.LocalDateTimeExtConst.MILLISECOND_PADDING
import and.degilevich.dream.shared.foundation.datetime.impl.common.ext.LocalDateTimeExtConst.MONTH_DAY_PADDING
import and.degilevich.dream.shared.foundation.datetime.impl.common.ext.LocalDateTimeExtConst.TIME_PADDING
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.Month
import kotlinx.datetime.number

internal fun LocalDateTime.isLeapYear(): Boolean {
    return (year % LEAP_YEAR_DIVISOR == 0 && year % CENTURY_DIVISOR != 0) || (year % FOUR_HUNDRED_YEAR_DIVISOR == 0)
}

internal fun LocalDateTime.daysInMonth(): Int {
    val month = this.month
    return when (month) {
        Month.JANUARY,
        Month.MARCH,
        Month.MAY,
        Month.JULY,
        Month.AUGUST,
        Month.OCTOBER,
        Month.DECEMBER -> {
            DAYS_IN_LONG_MONTH
        }

        Month.APRIL,
        Month.JUNE,
        Month.SEPTEMBER,
        Month.NOVEMBER -> {
            DAYS_IN_SHORT_MONTH
        }

        Month.FEBRUARY -> {
            if (isLeapYear()) DAYS_IN_FEBRUARY_LEAP_YEAR else DAYS_IN_FEBRUARY_COMMON_YEAR
        }
    }
}

internal fun startUnixLocalDateTime() = LocalDateTime(
    year = 1970,
    month = 1,
    day = 1,
    hour = 0,
    minute = 0
)

internal fun LocalDateTime.formatToIso8601(): String {
    return buildString {
        append(year.toString().padStart(LocalDateTimeExtConst.YEAR_PADDING, '0')) // Year
        append("-")
        append(month.number.toString().padStart(MONTH_DAY_PADDING, '0')) // Month
        append("-")
        append(day.toString().padStart(MONTH_DAY_PADDING, '0')) // Day
        append("T")
        append(hour.toString().padStart(TIME_PADDING, '0')) // Hour
        append(":")
        append(minute.toString().padStart(TIME_PADDING, '0')) // Minute
        append(":")
        append(second.toString().padStart(TIME_PADDING, '0')) // Second
        append(".")
        append(
            (nanosecond / LocalDateTimeExtConst.NANOSECOND_DIVISOR)
                .toString()
                .padStart(MILLISECOND_PADDING, '0')
        ) // Millisecond
        append("Z") // UTC-suffix
    }
}

internal fun LocalDateTime.buildStartByNanoseconds() = LocalDateTime(
    year = year,
    month = month.number,
    day = day,
    hour = hour,
    minute = minute,
    second = second,
    nanosecond = 0
)

internal fun LocalDateTime.buildStartByMinute() = LocalDateTime(
    year = year,
    month = month.number,
    day = day,
    hour = hour,
    minute = minute,
    second = 0,
    nanosecond = 0
)

internal fun LocalDateTime.buildStartByHour() = LocalDateTime(
    year = year,
    month = month.number,
    day = day,
    hour = hour,
    minute = 0,
    second = 0,
    nanosecond = 0
)

internal fun LocalDateTime.buildStartByDay() = LocalDateTime(
    year = year,
    month = month.number,
    day = day,
    hour = 0,
    minute = 0,
    second = 0,
    nanosecond = 0
)

internal fun LocalDateTime.buildStartByMonth() = LocalDateTime(
    year = year,
    month = month.number,
    day = 1,
    hour = 0,
    minute = 0,
    second = 0,
    nanosecond = 0
)

internal fun LocalDateTime.buildStartByYear() = LocalDateTime(
    year = year,
    month = 1,
    day = 1,
    hour = 0,
    minute = 0,
    second = 0,
    nanosecond = 0
)

internal fun LocalDateTime.buildEndByNanosecond() = LocalDateTime(
    year = year,
    month = month.number,
    day = day,
    hour = hour,
    minute = minute,
    second = second,
    nanosecond = 999_999_999
)

internal fun LocalDateTime.buildEndByMinute() = LocalDateTime(
    year = year,
    month = month.number,
    day = day,
    hour = hour,
    minute = minute,
    second = 59,
    nanosecond = 999_999_999
)

internal fun LocalDateTime.buildEndByHour() = LocalDateTime(
    year = year,
    month = month.number,
    day = day,
    hour = hour,
    minute = 59,
    second = 59,
    nanosecond = 999_999_999
)

internal fun LocalDateTime.buildEndByDay() = LocalDateTime(
    year = year,
    month = month.number,
    day = day,
    hour = 23,
    minute = 59,
    second = 59,
    nanosecond = 999_999_999
)

internal fun LocalDateTime.buildEndByMonth() = LocalDateTime(
    year = year,
    month = month.number,
    day = daysInMonth(),
    hour = 23,
    minute = 59,
    second = 59,
    nanosecond = 999_999_999
)

internal fun LocalDateTime.buildEndByYear() = LocalDateTime(
    year = year,
    month = 12,
    day = 31,
    hour = 23,
    minute = 59,
    second = 59,
    nanosecond = 999_999_999
)

private object LocalDateTimeExtConst {
    const val LEAP_YEAR_DIVISOR = 4
    const val CENTURY_DIVISOR = 100
    const val FOUR_HUNDRED_YEAR_DIVISOR = 400

    const val DAYS_IN_LONG_MONTH = 31
    const val DAYS_IN_SHORT_MONTH = 30
    const val DAYS_IN_FEBRUARY_LEAP_YEAR = 29
    const val DAYS_IN_FEBRUARY_COMMON_YEAR = 28

    const val YEAR_PADDING = 4
    const val MONTH_DAY_PADDING = 2
    const val TIME_PADDING = 2
    const val MILLISECOND_PADDING = 3
    const val NANOSECOND_DIVISOR = 1_000_000
}