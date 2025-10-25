package and.degilevich.dream.shared.foundation.datetime.impl.current

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeFormat
import and.degilevich.dream.shared.foundation.datetime.impl.common.TimeUnit

internal class CurrentDateConfig(
    val format: DateTimeFormat,
    val isConvertToLocal: Boolean,
    val offset: Int = 0,
    val offsetUnit: TimeUnit,
)