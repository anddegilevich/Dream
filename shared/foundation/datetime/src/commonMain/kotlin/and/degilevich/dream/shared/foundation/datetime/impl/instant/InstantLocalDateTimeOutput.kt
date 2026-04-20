package and.degilevich.dream.shared.foundation.datetime.impl.instant

import kotlinx.datetime.LocalDateTime
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
internal class InstantLocalDateTimeOutput(
    val instant: Instant,
    val localDateTime: LocalDateTime
)