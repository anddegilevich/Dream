package and.degilevich.dream.shared.core.datetime.test.between

import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError
import and.degilevich.dream.shared.foundation.datetime.api.between.TimeBetweenDates
import and.degilevich.dream.shared.foundation.datetime.api.between.TimeBetweenDatesConfigBuilderScope
import and.degilevich.dream.shared.foundation.datetime.api.between.TimeBetweenNowAndDateConfigBuilderScope

class FakeTimeBetweenDates(
    private val onTimeBetweenNowAndDateResult: () -> Result<Long> = { fakeImplementationError() },
    private val onTimeBetweenNowAndDate: () -> Long = { fakeImplementationError() },
    private val onTimeBetweenDatesResult: () -> Result<Long> = { fakeImplementationError() },
    private val onTimeBetweenDates: () -> Long = { fakeImplementationError() }
) : TimeBetweenDates {

    override fun timeBetweenNowAndDateResult(
        block: TimeBetweenNowAndDateConfigBuilderScope.() -> Unit
    ): Result<Long> {
        return onTimeBetweenNowAndDateResult()
    }

    override fun timeBetweenNowAndDate(block: TimeBetweenNowAndDateConfigBuilderScope.() -> Unit): Long {
        return onTimeBetweenNowAndDate()
    }

    override fun timeBetweenDatesResult(block: TimeBetweenDatesConfigBuilderScope.() -> Unit): Result<Long> {
        return onTimeBetweenDatesResult()
    }

    override fun timeBetweenDates(block: TimeBetweenDatesConfigBuilderScope.() -> Unit): Long {
        return onTimeBetweenDates()
    }
}
