package and.degilevich.dream.shared.foundation.datetime.impl.verification

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput
import kotlin.time.Duration

internal data class VerificationDateWithOffsetConfig(
    val input: DateTimeInput,
    val duration: Duration
)