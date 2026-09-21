package and.degilevich.dream.shared.core.service.test.model

import and.degilevich.dream.shared.core.service.api.generated.model.PagingSavedTrackObject
import and.degilevich.dream.shared.core.service.api.generated.model.SavedTrackObject

fun pagingSavedTrackObject(
    items: List<SavedTrackObject> = emptyList(),
    total: Int = items.size,
    offset: Int = 0
): PagingSavedTrackObject = PagingSavedTrackObject(
    href = "https://api.spotify.com/v1/me/tracks",
    limit = 20,
    next = null,
    offset = offset,
    previous = null,
    total = total,
    items = items
)
