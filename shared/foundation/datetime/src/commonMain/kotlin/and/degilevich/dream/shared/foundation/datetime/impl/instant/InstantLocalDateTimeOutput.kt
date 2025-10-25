package and.degilevich.dream.shared.foundation.datetime.impl.instant

import kotlin.time.Instant
import kotlinx.datetime.LocalDateTime
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
internal class InstantLocalDateTimeOutput(
    val instant: Instant,
    val localDateTime: LocalDateTime
)