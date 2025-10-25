package and.degilevich.dream.shared.foundation.datetime.api.between

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput
import and.degilevich.dream.shared.foundation.datetime.impl.common.TimeUnit

interface TimeBetweenDatesConfigBuilderScope {
    fun setStartInput(value: DateTimeInput)
    fun setEndInput(value: DateTimeInput)
    fun setUnit(value: TimeUnit)
}