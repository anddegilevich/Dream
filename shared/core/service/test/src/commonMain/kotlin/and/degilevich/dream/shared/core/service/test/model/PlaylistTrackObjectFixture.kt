package and.degilevich.dream.shared.core.service.test.model

import and.degilevich.dream.shared.core.service.api.generated.model.PlaylistTrackObject
import and.degilevich.dream.shared.core.service.api.generated.model.TrackObject

fun playlistTrackObject(
    addedAt: String? = "2024-01-01T00:00:00Z",
    item: TrackObject? = trackObject()
): PlaylistTrackObject = PlaylistTrackObject(
    addedAt = addedAt,
    addedBy = null,
    isLocal = false,
    item = item
)
