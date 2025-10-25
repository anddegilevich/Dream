package and.degilevich.dream.shared.foundation.datetime.api.verification

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput
import kotlin.time.Duration

interface VerificationDateWithOffsetBuilderScope {
    fun setInput(input: DateTimeInput)
    fun setOffset(duration: Duration)
}