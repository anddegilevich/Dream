package and.degilevich.dream.shared.core.service.test.model

import and.degilevich.dream.shared.core.service.api.generated.model.CursorObject
import and.degilevich.dream.shared.core.service.api.generated.model.CursorPagingPlayHistoryObject
import and.degilevich.dream.shared.core.service.api.generated.model.PlayHistoryObject

fun cursorPagingPlayHistoryObject(
    items: List<PlayHistoryObject>? = emptyList(),
    limit: Int? = 20,
    cursors: CursorObject? = null
): CursorPagingPlayHistoryObject = CursorPagingPlayHistoryObject(
    href = "https://api.spotify.com/v1/me/player/recently-played",
    limit = limit,
    next = null,
    cursors = cursors,
    total = items?.size,
    items = items
)
