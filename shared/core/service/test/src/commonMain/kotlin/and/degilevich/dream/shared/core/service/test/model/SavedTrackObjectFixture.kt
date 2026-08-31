package and.degilevich.dream.shared.core.service.test.model

import and.degilevich.dream.shared.core.service.api.generated.model.SavedTrackObject
import and.degilevich.dream.shared.core.service.api.generated.model.TrackObject

fun savedTrackObject(
    addedAt: String = "2024-01-01T00:00:00Z",
    track: TrackObject? = trackObject()
): SavedTrackObject = SavedTrackObject(
    addedAt = addedAt,
    track = track
)
