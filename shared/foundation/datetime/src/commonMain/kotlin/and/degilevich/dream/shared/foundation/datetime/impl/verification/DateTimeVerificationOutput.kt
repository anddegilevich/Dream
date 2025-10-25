package and.degilevich.dream.shared.foundation.datetime.impl.verification

import kotlinx.datetime.LocalDateTime

internal data class DateTimeVerificationOutput(
    val currentDate: LocalDateTime,
    val inputDate: LocalDateTime
)