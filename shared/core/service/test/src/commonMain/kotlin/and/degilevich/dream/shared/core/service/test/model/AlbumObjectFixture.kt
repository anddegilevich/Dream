package and.degilevich.dream.shared.core.service.test.model

import and.degilevich.dream.shared.core.service.api.generated.model.AlbumObject
import and.degilevich.dream.shared.core.service.api.generated.model.ExternalIdObject
import and.degilevich.dream.shared.core.service.api.generated.model.ExternalUrlObject
import and.degilevich.dream.shared.core.service.api.generated.model.ImageObject
import and.degilevich.dream.shared.core.service.api.generated.model.PagingSimplifiedTrackObject
import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedArtistObject

fun albumObject(
    albumType: AlbumObject.AlbumType = AlbumObject.AlbumType.ALBUM,
    artists: List<SimplifiedArtistObject> = emptyList(),
    images: List<ImageObject> = emptyList(),
    tracks: PagingSimplifiedTrackObject = pagingSimplifiedTrackObject()
): AlbumObject = AlbumObject(
    albumType = albumType,
    totalTracks = 10,
    externalUrls = ExternalUrlObject(),
    href = "https://api.spotify.com/v1/albums/1",
    id = "album-id",
    images = images,
    name = "Album Name",
    releaseDate = "2021-05-20",
    releaseDatePrecision = AlbumObject.ReleaseDatePrecision.DAY,
    type = AlbumObject.Type.ALBUM,
    uri = "spotify:album:1",
    artists = artists,
    tracks = tracks,
    copyrights = emptyList(),
    externalIds = ExternalIdObject()
)
