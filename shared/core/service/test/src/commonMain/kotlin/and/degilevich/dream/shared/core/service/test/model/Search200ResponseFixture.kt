package and.degilevich.dream.shared.core.service.test.model

import and.degilevich.dream.shared.core.service.api.generated.model.PagingArtistObject
import and.degilevich.dream.shared.core.service.api.generated.model.PagingSimplifiedAlbumObject
import and.degilevich.dream.shared.core.service.api.generated.model.PagingTrackObject
import and.degilevich.dream.shared.core.service.api.generated.model.Search200Response

fun search200Response(
    tracks: PagingTrackObject? = pagingTrackObject(),
    artists: PagingArtistObject? = pagingArtistObject(),
    albums: PagingSimplifiedAlbumObject? = pagingSimplifiedAlbumObject()
): Search200Response = Search200Response(
    tracks = tracks,
    artists = artists,
    albums = albums
)
