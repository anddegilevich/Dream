package and.degilevich.dream.shared.core.service.test.model

import and.degilevich.dream.shared.core.service.api.generated.model.PlayHistoryObject
import and.degilevich.dream.shared.core.service.api.generated.model.TrackObject

fun playHistoryObject(
    track: TrackObject? = trackObject(),
    playedAt: String? = "2024-01-01T00:00:00Z"
): PlayHistoryObject = PlayHistoryObject(
    track = track,
    playedAt = playedAt,
    context = null
)
