package and.degilevich.dream.shared.foundation.datetime.api.unit

import and.degilevich.dream.shared.foundation.datetime.impl.common.TimeUnit
import kotlinx.datetime.DateTimeUnit

internal interface TimeUnitToDateTimeUnitMapper {
    fun map(unit: TimeUnit): DateTimeUnit
}