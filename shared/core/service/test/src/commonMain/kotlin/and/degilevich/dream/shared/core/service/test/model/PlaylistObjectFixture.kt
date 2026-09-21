package and.degilevich.dream.shared.core.service.test.model

import and.degilevich.dream.shared.core.service.api.generated.model.ExternalUrlObject
import and.degilevich.dream.shared.core.service.api.generated.model.ImageObject
import and.degilevich.dream.shared.core.service.api.generated.model.PagingPlaylistTrackObject
import and.degilevich.dream.shared.core.service.api.generated.model.PlaylistObject

fun playlistObject(
    id: String? = "playlist-id",
    name: String? = "Playlist Name",
    description: String? = "Playlist Description",
    images: List<ImageObject>? = emptyList(),
    items: PagingPlaylistTrackObject? = null
): PlaylistObject = PlaylistObject(
    collaborative = false,
    description = description,
    externalUrls = ExternalUrlObject(),
    href = "https://api.spotify.com/v1/playlists/1",
    id = id,
    images = images,
    name = name,
    owner = null,
    `public` = true,
    snapshotId = "snapshot-id",
    items = items,
    type = "playlist",
    uri = "spotify:playlist:1"
)
