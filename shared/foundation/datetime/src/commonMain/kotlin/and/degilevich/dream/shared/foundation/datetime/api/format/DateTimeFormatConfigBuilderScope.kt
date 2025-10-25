package and.degilevich.dream.shared.foundation.datetime.api.format

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput
import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeFormat

/**
 * Builder scope for configuring date and time formatting.
 */
interface DateTimeFormatConfigBuilderScope {
    /**
     * Sets the input date to be formatted.
     *
     * @param input The input date, provided as a [DateTimeInput].
     */
    fun setInput(input: DateTimeInput)

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
}