package and.degilevich.dream.shared.core.service.test.model

import and.degilevich.dream.shared.core.service.api.generated.model.PagingPlaylistTrackObject
import and.degilevich.dream.shared.core.service.api.generated.model.PlaylistTrackObject

fun pagingPlaylistTrackObject(
    items: List<PlaylistTrackObject> = emptyList(),
    total: Int = items.size,
    offset: Int = 0
): PagingPlaylistTrackObject = PagingPlaylistTrackObject(
    href = "https://api.spotify.com/v1/playlists/1/items",
    limit = 20,
    next = null,
    offset = offset,
    previous = null,
    total = total,
    items = items
)
