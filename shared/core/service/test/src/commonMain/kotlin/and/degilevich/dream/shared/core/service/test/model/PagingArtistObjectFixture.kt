package and.degilevich.dream.shared.core.service.test.model

import and.degilevich.dream.shared.core.service.api.generated.model.ArtistObject
import and.degilevich.dream.shared.core.service.api.generated.model.PagingArtistObject

fun pagingArtistObject(
    items: List<ArtistObject> = emptyList()
): PagingArtistObject = PagingArtistObject(
    href = "https://api.spotify.com/v1/search",
    limit = 20,
    next = null,
    offset = 0,
    previous = null,
    total = items.size,
    items = items
)
