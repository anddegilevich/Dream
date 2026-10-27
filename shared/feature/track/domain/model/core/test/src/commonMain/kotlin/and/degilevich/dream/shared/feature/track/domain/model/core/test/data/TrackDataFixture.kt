package and.degilevich.dream.shared.feature.track.domain.model.core.test.data

import and.degilevich.dream.shared.feature.album.domain.model.artifact.api.data.SimplifiedAlbumData
import and.degilevich.dream.shared.feature.artist.domain.model.artifact.api.data.SimplifiedArtistData
import and.degilevich.dream.shared.feature.track.domain.model.artifact.api.data.TrackId
import and.degilevich.dream.shared.feature.track.domain.model.core.api.data.TrackData

fun trackData(
    id: String,
    trackNumber: Int = 1,
    durationMs: Int = 1000,
    album: SimplifiedAlbumData = SimplifiedAlbumData.empty(),
    artists: List<SimplifiedArtistData> = emptyList()
): TrackData = TrackData(
    id = TrackId(value = id),
    name = "Track $id",
    album = album,
    trackNumber = trackNumber,
    durationMs = durationMs,
    artists = artists
)
