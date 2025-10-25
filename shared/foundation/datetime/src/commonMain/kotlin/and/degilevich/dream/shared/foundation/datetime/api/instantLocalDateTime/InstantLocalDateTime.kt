package and.degilevich.dream.shared.foundation.datetime.api.instantLocalDateTime

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput
import and.degilevich.dream.shared.foundation.datetime.impl.instant.InstantLocalDateTimeOutput

internal interface InstantLocalDateTime {
    fun instantLocalDateTimeOutputResult(
        input: DateTimeInput,
        convertToLocal: Boolean
    ): Result<InstantLocalDateTimeOutput>
}