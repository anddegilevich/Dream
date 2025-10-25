package and.degilevich.dream.shared.foundation.datetime.api.between

/**
 * An interface for calculating the time difference between dates.
 *
 * Each method comes in two variants:
 * - A method returning a [Result] for safe error handling.
 * - A direct method returning a `Long`, which may return `0L` in case of an error.
 */
interface TimeBetweenDates {

    /**
     * Calculates the time difference between the current moment and a specified date.
     * The configuration is provided via a [TimeBetweenNowAndDateConfigBuilderScope] block.
     * A positive value indicates a future date relative to the current moment,
     * while a negative value represents the time elapsed since the given date.
     *
     * @param block A lambda for configuration.
     * @return A [Result] containing the computed time difference in the specified unit,
     * or an error if the computation fails.
     */
    fun timeBetweenNowAndDateResult(block: TimeBetweenNowAndDateConfigBuilderScope.() -> Unit): Result<Long>

    /**
     * Calculates the time difference between the current moment and a specified date.
     * The configuration is provided via a [TimeBetweenNowAndDateConfigBuilderScope] block.
     * A positive value indicates a future date relative to the current moment,
     * while a negative value represents the time elapsed since the given date.
     *
     * @param block A lambda for configuration.
     * @return A [Long] the computed time difference in time difference in the specified unit,
     * or 0L if the computation fails.
     */
    fun timeBetweenNowAndDate(block: TimeBetweenNowAndDateConfigBuilderScope.() -> Unit): Long

    /**
     * Calculates the time difference between two specified dates.
     * A positive value indicates that the end date is in the future relative to the start date,
     * while a negative value represents the time elapsed since the end date.
     * The configuration is provided via a [TimeBetweenDatesConfigBuilderScope] block.
     *
     * @param block A lambda for configuring.
     * @return A [Result] representing the computed time difference in the specified unit,
     * or an error if the computation fails.
     */
    fun timeBetweenDatesResult(block: TimeBetweenDatesConfigBuilderScope.() -> Unit): Result<Long>

    /**
     * Calculates the time difference between two specified dates.
     * A positive value indicates that the end date is in the future relative to the start date,
     * while a negative value represents the time elapsed since the end date.
     * The configuration is provided via a [TimeBetweenDatesConfigBuilderScope] block.
     *
     * @param block A lambda for configuring.
     * @return A [Long] representing the computed time difference in the specified unit,
     * or 0L if the computation fails.
     */
    fun timeBetweenDates(block: TimeBetweenDatesConfigBuilderScope.() -> Unit): Long
}