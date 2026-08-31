package and.degilevich.dream.shared.core.service.test.model

import and.degilevich.dream.shared.core.service.api.generated.model.PagingPlaylistObject
import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedPlaylistObject

fun pagingPlaylistObject(
    items: List<SimplifiedPlaylistObject> = emptyList()
): PagingPlaylistObject = PagingPlaylistObject(
    href = "https://api.spotify.com/v1/me/playlists",
    limit = 20,
    next = null,
    offset = 0,
    previous = null,
    total = items.size,
    items = items
)
