package and.degilevich.dream.shared.foundation.datetime.api.format

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput

/**
 * Interface for formatting dates and times.
 */
interface DateTimeFormatter {

    /**
     * Formats a date based on the provided configuration block.
     * Returns the result wrapped in a [Result] to handle errors safely.
     *
     * @param block lambda to configure the formatting using [DateTimeFormatConfigBuilderScope].
     * @return [Result] containing the formatted date string or an error.
     */
    fun formatResult(block: DateTimeFormatConfigBuilderScope.() -> Unit = { }): Result<String>

    /**
     * Formats a date based on the provided configuration block.
     * If an error occurs during formatting, an empty string is returned.
     *
     * @param block lambda to configure the formatting using [DateTimeFormatConfigBuilderScope].
     * @return The formatted date string, or an empty string in case of an error.
     */
    fun format(block: DateTimeFormatConfigBuilderScope.() -> Unit = { }): String

    /**
     * Converts the input date to the Unix timestamp (milliseconds since the Unix epoch).
     * Returns the result wrapped in a [Result] to handle errors safely.
     *
     * @param input The input date to be converted, provided as a [DateTimeInput].
     * @return [Result] containing the Unix timestamp in milliseconds or an error.
     */
    fun formatToMillisResult(input: DateTimeInput): Result<Long>

    /**
     * Converts the input date to the Unix timestamp (milliseconds since the Unix epoch).
     * If an error occurs during conversion, -1 is returned.
     *
     * @param input The input date to be converted, provided as a [DateTimeInput].
     * @return The Unix timestamp in milliseconds, or -1 in case of an error.
     */
    fun formatToMillis(input: DateTimeInput): Long
}