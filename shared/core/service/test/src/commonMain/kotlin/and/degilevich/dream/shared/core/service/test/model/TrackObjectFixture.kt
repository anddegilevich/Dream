package and.degilevich.dream.shared.core.service.test.model

import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedAlbumObject
import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedArtistObject
import and.degilevich.dream.shared.core.service.api.generated.model.TrackObject

fun trackObject(
    album: SimplifiedAlbumObject? = simplifiedAlbumObject(),
    artists: List<SimplifiedArtistObject> = emptyList()
): TrackObject = TrackObject(
    album = album,
    artists = artists,
    durationMs = 200000,
    href = "https://api.spotify.com/v1/tracks/1",
    id = "track-id",
    name = "Track Name",
    trackNumber = 1,
    type = TrackObject.Type.TRACK,
    uri = "spotify:track:1"
)
