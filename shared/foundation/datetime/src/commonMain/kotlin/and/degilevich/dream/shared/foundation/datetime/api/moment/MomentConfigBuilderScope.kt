package and.degilevich.dream.shared.foundation.datetime.api.moment

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeFormat
import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput
import and.degilevich.dream.shared.foundation.datetime.impl.common.TimeUnit

interface MomentConfigBuilderScope {
    fun setInput(input: DateTimeInput)
    fun setConvertToLocal(isConverted: Boolean)
    fun setUnit(unit: TimeUnit)
    fun setOutputFormat(format: DateTimeFormat)
}