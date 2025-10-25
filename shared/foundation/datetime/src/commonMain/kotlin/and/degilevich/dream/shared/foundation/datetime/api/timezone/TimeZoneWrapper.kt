package and.degilevich.dream.shared.foundation.datetime.api.timezone

import kotlinx.datetime.TimeZone

internal interface TimeZoneWrapper {
    fun defaultTimeZone(): TimeZone
    fun systemTimeZone(): TimeZone
    fun timeZoneByLocal(convertToLocal: Boolean): TimeZone
}