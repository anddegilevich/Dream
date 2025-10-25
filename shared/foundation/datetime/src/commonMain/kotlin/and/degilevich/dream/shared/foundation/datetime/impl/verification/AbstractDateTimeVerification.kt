package and.degilevich.dream.shared.foundation.datetime.impl.verification

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput
import and.degilevich.dream.shared.foundation.datetime.api.instant.InstantWrapper
import and.degilevich.dream.shared.foundation.datetime.api.localDateTime.LocalDateTimeWrapper
import and.degilevich.dream.shared.foundation.datetime.api.timezone.TimeZoneWrapper
import and.degilevich.dream.shared.foundation.datetime.api.verification.DateTimeVerification
import and.degilevich.dream.shared.foundation.primitive.result.foldResult
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
internal abstract class AbstractDateTimeVerification(
    private val instant: InstantWrapper,
    private val timeZone: TimeZoneWrapper,
    private val localDateTime: LocalDateTimeWrapper
) : DateTimeVerification {

    internal fun currentTimeVerificationOutputResult(
        input: DateTimeInput,
        isConvertToLocal: Boolean
    ): Result<DateTimeVerificationOutput> {
        val currentInstant = instant.currentInstant()
        val timeZone = timeZone.timeZoneByLocal(isConvertToLocal)
        return instant.timeInstantResult(input).foldResult { instantByInput ->
            localDateTime.localDateTimeByInstantResult(
                instant = instantByInput,
                timeZone = timeZone
            ).foldResult { inputLocalDateTime ->
                localDateTime.localDateTimeByInstantResult(
                    instant = currentInstant,
                    timeZone = timeZone
                ).foldResult { currentLocalDateTime ->
                    Result.success(
                        DateTimeVerificationOutput(
                            currentDate = currentLocalDateTime,
                            inputDate = inputLocalDateTime
                        )
                    )
                }
            }
        }
    }
}