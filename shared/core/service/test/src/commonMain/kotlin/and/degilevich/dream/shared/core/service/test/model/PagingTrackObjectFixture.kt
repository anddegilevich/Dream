package and.degilevich.dream.shared.core.service.test.model

import and.degilevich.dream.shared.core.service.api.generated.model.PagingTrackObject
import and.degilevich.dream.shared.core.service.api.generated.model.TrackObject

fun pagingTrackObject(
    items: List<TrackObject> = emptyList(),
    total: Int = items.size
): PagingTrackObject = PagingTrackObject(
    href = "https://api.spotify.com/v1/search",
    limit = 20,
    next = null,
    offset = 0,
    previous = null,
    total = total,
    items = items
)
