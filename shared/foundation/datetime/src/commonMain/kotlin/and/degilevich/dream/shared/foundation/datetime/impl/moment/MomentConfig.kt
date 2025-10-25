package and.degilevich.dream.shared.foundation.datetime.impl.moment

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeFormat
import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput
import and.degilevich.dream.shared.foundation.datetime.impl.common.TimeUnit

internal class MomentConfig(
    val input: DateTimeInput,
    val convertToLocal: Boolean,
    val unit: TimeUnit,
    val outputFormat: DateTimeFormat
)