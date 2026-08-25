package and.degilevich.dream.shared.core.service.impl.datetime

import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError
import and.degilevich.dream.shared.foundation.datetime.api.current.CurrentDateTime
import and.degilevich.dream.shared.foundation.datetime.api.current.CurrentDateTimeConfigBuilderScope

internal class FakeCurrentDateTime(
    private val onCurrentTimeMillis: () -> Long = { fakeImplementationError() },
    private val onCurrentDateTimeResult: (CurrentDateTimeConfigBuilderScope.() -> Unit) -> Result<String> = {
        fakeImplementationError()
    },
    private val onCurrentDateTime: (block: CurrentDateTimeConfigBuilderScope.() -> Unit) -> String = {
        fakeImplementationError()
    }
) : CurrentDateTime {

    override fun currentTimeMillis(): Long {
        return onCurrentTimeMillis()
    }

    override fun currentDateTimeResult(block: CurrentDateTimeConfigBuilderScope.() -> Unit): Result<String> {
        return onCurrentDateTimeResult(block)
    }

    override fun currentDateTime(block: CurrentDateTimeConfigBuilderScope.() -> Unit): String {
        return onCurrentDateTime(block)
    }
}
