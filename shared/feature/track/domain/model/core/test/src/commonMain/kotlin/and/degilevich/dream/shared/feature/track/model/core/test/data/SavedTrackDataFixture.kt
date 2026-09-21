package and.degilevich.dream.shared.feature.track.model.core.test.data

import and.degilevich.dream.shared.feature.track.model.core.api.data.SavedTrackData
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData

fun savedTrackData(
    id: String,
    addedAt: String = "2024-01-01T00:00:00Z",
    track: TrackData = trackData(id = id)
): SavedTrackData = SavedTrackData(
    track = track,
    addedAt = addedAt
)
