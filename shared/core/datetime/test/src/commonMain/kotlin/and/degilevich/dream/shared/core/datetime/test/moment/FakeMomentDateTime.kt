package and.degilevich.dream.shared.core.datetime.test.moment

import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError
import and.degilevich.dream.shared.foundation.datetime.api.moment.MomentConfigBuilderScope
import and.degilevich.dream.shared.foundation.datetime.api.moment.MomentDateTime

class FakeMomentDateTime(
    private val onStartOfDateUnitResult: () -> Result<String> = { fakeImplementationError() },
    private val onStartOfDateUnit: () -> String = { fakeImplementationError() },
    private val onEndOfDateUnitResult: () -> Result<String> = { fakeImplementationError() },
    private val onEndOfDateUnit: () -> String = { fakeImplementationError() }
) : MomentDateTime {

    override fun startOfDateUnitResult(block: MomentConfigBuilderScope.() -> Unit): Result<String> {
        return onStartOfDateUnitResult()
    }

    override fun startOfDateUnit(block: MomentConfigBuilderScope.() -> Unit): String {
        return onStartOfDateUnit()
    }

    override fun endOfDateUnitResult(block: MomentConfigBuilderScope.() -> Unit): Result<String> {
        return onEndOfDateUnitResult()
    }

    override fun endOfDateUnit(block: MomentConfigBuilderScope.() -> Unit): String {
        return onEndOfDateUnit()
    }
}
