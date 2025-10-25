package and.degilevich.dream.shared.foundation.datetime.impl.format

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeFormat
import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput

internal data class DateTimeFormatConfig(
    val input: DateTimeInput,
    val output: DateTimeFormat,
    val convertToLocal: Boolean,
)