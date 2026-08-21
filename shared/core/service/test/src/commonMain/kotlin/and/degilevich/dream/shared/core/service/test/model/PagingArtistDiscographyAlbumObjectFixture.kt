package and.degilevich.dream.shared.core.service.test.model

import and.degilevich.dream.shared.core.service.api.generated.model.PagingArtistDiscographyAlbumObject
import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedAlbumObject

fun pagingArtistDiscographyAlbumObject(
    items: List<SimplifiedAlbumObject> = emptyList()
): PagingArtistDiscographyAlbumObject = PagingArtistDiscographyAlbumObject(
    href = "https://api.spotify.com/v1/artists/1/albums",
    limit = 20,
    next = null,
    offset = 0,
    previous = null,
    total = items.size,
    items = items
)
