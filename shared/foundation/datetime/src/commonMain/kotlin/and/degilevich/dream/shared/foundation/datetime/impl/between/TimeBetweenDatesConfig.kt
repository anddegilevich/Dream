package and.degilevich.dream.shared.foundation.datetime.impl.between

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput
import and.degilevich.dream.shared.foundation.datetime.impl.common.TimeUnit

internal class TimeBetweenDatesConfig(
    val startInput: DateTimeInput,
    val endInput: DateTimeInput,
    val unit: TimeUnit
)