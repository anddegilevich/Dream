package and.degilevich.dream.shared.foundation.datetime.impl.unit

import and.degilevich.dream.shared.foundation.datetime.api.unit.TimeUnitToDateTimeUnitMapper
import and.degilevich.dream.shared.foundation.datetime.impl.common.TimeUnit
import kotlinx.datetime.DateTimeUnit

internal class TimeUnitToDateTimeUnitMapperImpl : TimeUnitToDateTimeUnitMapper {
    override fun map(unit: TimeUnit): DateTimeUnit {
        return when (unit) {
            TimeUnit.MILLISECOND -> DateTimeUnit.MILLISECOND
            TimeUnit.SECOND -> DateTimeUnit.SECOND
            TimeUnit.MINUTE -> DateTimeUnit.MINUTE
            TimeUnit.HOUR -> DateTimeUnit.HOUR
            TimeUnit.DAY -> DateTimeUnit.DAY
            TimeUnit.MONTH -> DateTimeUnit.MONTH
            TimeUnit.YEAR -> DateTimeUnit.YEAR
        }
    }
}