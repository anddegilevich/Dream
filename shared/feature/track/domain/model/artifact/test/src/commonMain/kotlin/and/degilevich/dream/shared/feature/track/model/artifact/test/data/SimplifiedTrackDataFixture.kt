package and.degilevich.dream.shared.feature.track.model.artifact.test.data

import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.SimplifiedArtistData
import and.degilevich.dream.shared.feature.track.model.artifact.api.data.SimplifiedTrackData
import and.degilevich.dream.shared.feature.track.model.artifact.api.data.TrackId

fun simplifiedTrackData(
    id: String,
    trackNumber: Int = 1,
    artists: List<SimplifiedArtistData> = emptyList()
): SimplifiedTrackData = SimplifiedTrackData(
    id = TrackId(value = id),
    name = "Track $id",
    trackNumber = trackNumber,
    durationMs = 1000,
    artists = artists
)
