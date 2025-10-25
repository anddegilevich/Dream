package and.degilevich.dream.shared.foundation.datetime.api.current

/**
 * Interface for working with current date and time.
 */
interface CurrentDateTime {

    /**
     * Returns the current date and time as the number of milliseconds since the Unix epoch
     * (January 1, 1970, 00:00:00 UTC).
     *
     * @return the current time in milliseconds.
     */
    fun currentTimeMillis(): Long

    /**
     * Returns the current date and time as a formatted string, using the provided configuration block.
     * The result is wrapped in a [Result] to safely handle errors.
     *
     * @param block lambda to configure the date and time settings using [CurrentDateTimeConfigBuilderScope].
     * @return [Result] containing the formatted date string or an error.
     */
    fun currentDateTimeResult(block: CurrentDateTimeConfigBuilderScope.() -> Unit): Result<String>

    /**
     * Returns the current date and time as a formatted string, using the provided configuration block.
     * If an error occurs during processing, an empty string is returned.
     *
     * @param block lambda to configure the date and time settings using [CurrentDateTimeConfigBuilderScope].
     * @return The formatted date string, or an empty string in case of an error.
     */
    fun currentDateTime(block: CurrentDateTimeConfigBuilderScope.() -> Unit): String
}