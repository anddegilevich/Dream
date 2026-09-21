package and.degilevich.dream.shared.feature.playlist.model.core.test.data

import and.degilevich.dream.shared.feature.playlist.model.core.api.data.PlaylistTrackData
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.test.data.trackData

fun playlistTrackData(
    id: String,
    addedAt: String = "2024-01-01T00:00:00Z",
    track: TrackData = trackData(id = id)
): PlaylistTrackData = PlaylistTrackData(
    track = track,
    addedAt = addedAt
)
