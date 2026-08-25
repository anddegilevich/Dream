package and.degilevich.dream.shared.core.service.impl.datetime

import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError
import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput
import and.degilevich.dream.shared.foundation.datetime.api.format.DateTimeFormatConfigBuilderScope
import and.degilevich.dream.shared.foundation.datetime.api.format.DateTimeFormatter

internal class FakeDateTimeFormatter(
    private val onFormatResult: () -> Result<String> = { fakeImplementationError() },
    private val onFormat: () -> String = { fakeImplementationError() },
    private val onFormatToMillisResult: () -> Result<Long> = { fakeImplementationError() },
    private val onFormatToMillis: () -> Long = { fakeImplementationError() }
) : DateTimeFormatter {

    override fun formatResult(block: DateTimeFormatConfigBuilderScope.() -> Unit): Result<String> {
        return onFormatResult()
    }

    override fun format(block: DateTimeFormatConfigBuilderScope.() -> Unit): String {
        return onFormat()
    }

    override fun formatToMillisResult(input: DateTimeInput): Result<Long> {
        return onFormatToMillisResult()
    }

    override fun formatToMillis(input: DateTimeInput): Long {
        return onFormatToMillis()
    }
}
