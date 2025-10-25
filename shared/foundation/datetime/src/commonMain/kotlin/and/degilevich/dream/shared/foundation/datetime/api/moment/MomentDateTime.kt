package and.degilevich.dream.shared.foundation.datetime.api.moment

/**
 * Interface for computing the start and end of a specified date unit
 * (such as day, month, or year) based on an input date.
 */
interface MomentDateTime {

    /**
     * Computes the start of the specified date unit (e.g., beginning of the year, month, or day)
     * based on the provided input date.
     *
     * @param block A configuration block for specifying the input date and target date unit.
     * @return A [Result] containing the formatted string representation of the computed start date-time or an error.
     */
    fun startOfDateUnitResult(block: MomentConfigBuilderScope.() -> Unit): Result<String>

    /**
     * Computes the start of the specified date unit (e.g., beginning of the year, month, or day)
     * based on the provided input date.
     *
     * @param block A configuration block for specifying the input date and target date unit.
     * @return formatted string representation of the computed start date-time or empty string when error.
     */
    fun startOfDateUnit(block: MomentConfigBuilderScope.() -> Unit): String

    /**
     * Computes the end of the specified date unit (e.g., beginning of the year, month, or day)
     * based on the provided input date.
     *
     * @param block A configuration block for specifying the input date and target date unit.
     * @return A [Result] containing the formatted string representation of the computed end date-time or an error.
     */
    fun endOfDateUnitResult(block: MomentConfigBuilderScope.() -> Unit): Result<String>

    /**
     * Computes the end of the specified date unit (e.g., beginning of the year, month, or day)
     * based on the provided input date.
     *
     * @param block A configuration block for specifying the input date and target date unit.
     * @return formatted string representation of the computed end date-time or empty string when error.
     */
    fun endOfDateUnit(block: MomentConfigBuilderScope.() -> Unit): String
}