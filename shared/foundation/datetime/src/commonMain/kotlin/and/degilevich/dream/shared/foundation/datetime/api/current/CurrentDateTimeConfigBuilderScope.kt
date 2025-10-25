package and.degilevich.dream.shared.foundation.datetime.api.current

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeFormat
import and.degilevich.dream.shared.foundation.datetime.impl.common.TimeUnit

interface CurrentDateTimeConfigBuilderScope {

    /**
     * Configures whether the date should be converted to the current local timezone.
     *
     * @param isConverted `true` to convert the date to the local timezone,
     * `false` to keep it in the default timezone (UTC).
     */
    fun setConvertToLocal(isConverted: Boolean)

    /**
     * Specifies the format for the output date string.
     *
     * @param format The desired format for the date and time, such as ISO 8601, TIMESTAMP, or custom formats.
     */
    fun setOutputFormat(format: DateTimeFormat)

    /**
     * Applies an offset to the current date, either in the past or future,
     * based on the provided offset value and time unit.
     *
     * @param offset The magnitude of the offset. Positive values move the date into the future,
     * while negative values move it into the past.
     * @param unit The unit of time for the offset (e.g., seconds, minutes, hours, days).
     */
    fun setOffset(offset: Int, unit: TimeUnit)
}