package and.degilevich.dream.shared.foundation.datetime.api.platform

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeFormat

internal interface PlatformDateFormatter {

    fun toDateFormatResult(
        date: String,
        formatFrom: DateTimeFormat,
        formatTo: DateTimeFormat
    ): Result<String>
}