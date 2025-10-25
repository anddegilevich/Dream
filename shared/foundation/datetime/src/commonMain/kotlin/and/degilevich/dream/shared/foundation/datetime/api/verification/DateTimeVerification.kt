package and.degilevich.dream.shared.foundation.datetime.api.verification

/**
 * An interface for verifying date and time values based on various conditions.
 *
 * This interface provides methods to check whether a given date falls into specific categories,
 * such as being in the past, future, today, yesterday, tomorrow, or within the current year.
 *
 * Each verification method comes in two variants:
 * - A method returning a [Result] for safe error handling.
 * - A direct method returning a `Boolean`, which may return `false` in case of an error.
 *
 */
interface DateTimeVerification : DateTimeVerificationBase {

    /**
     * Checks whether the given date corresponds to today’s date.
     *
     * @param block A lambda function for configuring parameters using [VerificationDateBuilderScope].
     * @return [Result] containing `true` if the date matches today’s date, otherwise `false`.
     * In case of an error, the [Result] will contain an exception.
     */
    fun isTodayResult(block: VerificationDateBuilderScope.() -> Unit): Result<Boolean>

    /**
     * Checks whether the given date corresponds to today’s date.
     *
     * @param block A lambda function for configuring parameters using [VerificationDateBuilderScope].
     * @return `true` if the date matches today’s date, otherwise `false`.
     * In case of an error, the return `false`
     */
    fun isToday(block: VerificationDateBuilderScope.() -> Unit): Boolean

    /**
     * Checks whether the given date corresponds to yesterday’s date.
     *
     * @param block A lambda function for configuring parameters using [VerificationDateBuilderScope].
     * @return [Result] containing `true` if the date matches yesterday’s date, otherwise `false`.
     * In case of an error, the [Result] will contain an exception.
     */
    fun isYesterdayResult(block: VerificationDateBuilderScope.() -> Unit): Result<Boolean>

    /**
     * Checks whether the given date corresponds to yesterday’s date.
     *
     * @param block A lambda function for configuring parameters using [VerificationDateBuilderScope].
     * @return `true` if the date matches yesterday’s date, otherwise `false`.
     * In case of an error, the return `false`
     */
    fun isYesterday(block: VerificationDateBuilderScope.() -> Unit): Boolean

    /**
     * Checks whether the given date corresponds to tomorrow’s date.
     *
     * @param block A lambda function for configuring parameters using [VerificationDateBuilderScope].
     * @return [Result] containing `true` if the date matches tomorrow’s date, otherwise `false`.
     * In case of an error, the [Result] will contain an exception.
     */
    fun isTomorrowResult(block: VerificationDateBuilderScope.() -> Unit): Result<Boolean>

    /**
     * Checks whether the given date corresponds to tomorrow’s date.
     *
     * @param block A lambda function for configuring parameters using [VerificationDateBuilderScope].
     * @return `true` if the date matches yesterday’s date, otherwise `false`.
     * In case of an error, the return `false`
     */
    fun isTomorrow(block: VerificationDateBuilderScope.() -> Unit): Boolean

    /**
     * Checks whether the given date falls within the current year.
     *
     * @param block A lambda function for configuring parameters using [VerificationDateBuilderScope].
     * @return [Result] containing `true` if the date is in the current year, otherwise `false`.
     * In case of an error, the [Result] will contain an exception.
     */
    fun isCurrentYearResult(block: VerificationDateBuilderScope.() -> Unit): Result<Boolean>

    /**
     * Checks whether the given date falls within the current year.
     *
     * @param block A lambda function for configuring parameters using [VerificationDateBuilderScope].
     * @return `true` if the date matches yesterday’s date, otherwise `false`.
     * In case of an error, the return `false`
     */
    fun isCurrentYear(block: VerificationDateBuilderScope.() -> Unit): Boolean
}