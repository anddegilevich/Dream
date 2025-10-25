package and.degilevich.dream.shared.foundation.datetime.api.verification

interface DateTimeVerificationBase {

    /**
     * Checks whether the given date in the configuration block is in the future, considering the specified offset.
     *
     * @param block A lambda function for configuring parameters using [VerificationDateWithOffsetBuilderScope].
     * @return [Result] containing `true` if the date is in the future, or `false` otherwise.
     * In case of an error, the [Result] will contain an exception.
     */
    fun isFutureDateWithOffsetResult(block: VerificationDateWithOffsetBuilderScope.() -> Unit): Result<Boolean>

    /**
     * Checks whether the given date in the configuration block is in the future, considering the specified offset.
     *
     * @param block A lambda function for configuring parameters using [VerificationDateWithOffsetBuilderScope].
     * @return `true` if the date is in the future, or `false` otherwise.
     * In case of an error, the return `false`
     */
    fun isFutureDateWithOffset(block: VerificationDateWithOffsetBuilderScope.() -> Unit): Boolean

    /**
     * Checks whether the given date in the configuration block is in the past, considering the specified offset.
     *
     * @param block A lambda function for configuring parameters using [VerificationDateWithOffsetBuilderScope].
     * @return [Result] containing `true` if the date is in the past, or `false` otherwise.
     * In case of an error, the [Result] will contain an exception.
     */
    fun isPastDateWithOffsetResult(block: VerificationDateWithOffsetBuilderScope.() -> Unit): Result<Boolean>

    /**
     * Checks whether the given date in the configuration block is in the past, considering the specified offset.
     *
     * @param block A lambda function for configuring parameters using [VerificationDateWithOffsetBuilderScope].
     * @return `true` if the date is in the past, or `false` otherwise.
     * In case of an error, the [Result] will contain an exception.
     */
    fun isPastDateWithOffset(block: VerificationDateWithOffsetBuilderScope.() -> Unit): Boolean
}