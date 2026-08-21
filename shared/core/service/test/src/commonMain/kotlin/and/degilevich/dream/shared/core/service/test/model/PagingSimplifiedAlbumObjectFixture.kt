package and.degilevich.dream.shared.core.service.test.model

import and.degilevich.dream.shared.core.service.api.generated.model.PagingSimplifiedAlbumObject
import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedAlbumObject

fun pagingSimplifiedAlbumObject(
    items: List<SimplifiedAlbumObject> = emptyList()
): PagingSimplifiedAlbumObject = PagingSimplifiedAlbumObject(
    href = "https://api.spotify.com/v1/search",
    limit = 20,
    next = null,
    offset = 0,
    previous = null,
    total = items.size,
    items = items
)
