package and.degilevich.dream.shared.core.service.test.model

import and.degilevich.dream.shared.core.service.api.generated.model.PagingSimplifiedTrackObject
import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedTrackObject

fun pagingSimplifiedTrackObject(
    items: List<SimplifiedTrackObject> = emptyList()
): PagingSimplifiedTrackObject = PagingSimplifiedTrackObject(
    href = "https://api.spotify.com/v1/albums/1/tracks",
    limit = 20,
    next = null,
    offset = 0,
    previous = null,
    total = items.size,
    items = items
)
