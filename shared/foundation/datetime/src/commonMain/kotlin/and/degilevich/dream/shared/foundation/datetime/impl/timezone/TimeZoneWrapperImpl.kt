package and.degilevich.dream.shared.foundation.datetime.impl.timezone

import and.degilevich.dream.shared.foundation.datetime.api.logger.DateTimeLogger
import and.degilevich.dream.shared.foundation.datetime.api.timezone.TimeZoneWrapper
import kotlinx.datetime.IllegalTimeZoneException
import kotlinx.datetime.TimeZone

internal class TimeZoneWrapperImpl(
    private val logger: DateTimeLogger
) : TimeZoneWrapper {
    override fun defaultTimeZone(): TimeZone = TimeZone.UTC

    override fun systemTimeZone(): TimeZone {
        return try {
            TimeZone.currentSystemDefault()
        } catch (e: IllegalTimeZoneException) {
            logger.logError(e)
            defaultTimeZone()
        }
    }

    override fun timeZoneByLocal(convertToLocal: Boolean): TimeZone {
        return if (convertToLocal) {
            systemTimeZone()
        } else {
            defaultTimeZone()
        }
    }
}