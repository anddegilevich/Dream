package and.degilevich.dream.shared.core.service.test.model

import and.degilevich.dream.shared.core.service.api.generated.model.ExternalUrlObject
import and.degilevich.dream.shared.core.service.api.generated.model.ImageObject
import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedAlbumObject
import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedArtistObject

fun simplifiedAlbumObject(
    albumType: SimplifiedAlbumObject.AlbumType = SimplifiedAlbumObject.AlbumType.ALBUM,
    artists: List<SimplifiedArtistObject> = emptyList(),
    images: List<ImageObject> = emptyList()
): SimplifiedAlbumObject = SimplifiedAlbumObject(
    albumType = albumType,
    totalTracks = 10,
    externalUrls = ExternalUrlObject(),
    href = "https://api.spotify.com/v1/albums/1",
    id = "album-id",
    images = images,
    name = "Album Name",
    releaseDate = "2021-05-20",
    releaseDatePrecision = SimplifiedAlbumObject.ReleaseDatePrecision.DAY,
    type = SimplifiedAlbumObject.Type.ALBUM,
    uri = "spotify:album:1",
    artists = artists
)
