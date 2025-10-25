package and.degilevich.dream.shared.foundation.datetime.impl.instantLocalDateTime

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput
import and.degilevich.dream.shared.foundation.datetime.api.instant.InstantWrapper
import and.degilevich.dream.shared.foundation.datetime.api.instantLocalDateTime.InstantLocalDateTime
import and.degilevich.dream.shared.foundation.datetime.api.localDateTime.LocalDateTimeWrapper
import and.degilevich.dream.shared.foundation.primitive.result.foldResult
import and.degilevich.dream.shared.foundation.datetime.impl.instant.InstantLocalDateTimeOutput
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
internal class InstantLocalDateTimeImpl(
    private val instant: InstantWrapper,
    private val localDateTime: LocalDateTimeWrapper
) : InstantLocalDateTime {

    override fun instantLocalDateTimeOutputResult(
        input: DateTimeInput,
        convertToLocal: Boolean
    ): Result<InstantLocalDateTimeOutput> {
        return instant.timeInstantResult(input = input).foldResult { instant ->
            localDateTime.instantToLocalDateTimeResult(
                instant = instant,
                convertToLocal = convertToLocal
            ).foldResult { localDateTime ->
                Result.success(
                    InstantLocalDateTimeOutput(
                        instant = instant,
                        localDateTime = localDateTime
                    )
                )
            }
        }
    }
}