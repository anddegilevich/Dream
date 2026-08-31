package and.degilevich.dream.shared.core.service.test.model

import and.degilevich.dream.shared.core.service.api.generated.model.ExternalUrlObject
import and.degilevich.dream.shared.core.service.api.generated.model.ImageObject
import and.degilevich.dream.shared.core.service.api.generated.model.PlaylistTracksRefObject
import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedPlaylistObject

fun simplifiedPlaylistObject(
    id: String? = "playlist-id",
    name: String? = "Playlist Name",
    description: String? = "Playlist Description",
    totalTracks: Int? = 10,
    images: List<ImageObject>? = emptyList()
): SimplifiedPlaylistObject = SimplifiedPlaylistObject(
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
    items = PlaylistTracksRefObject(
        href = "https://api.spotify.com/v1/playlists/1/tracks",
        total = totalTracks
    ),
    type = "playlist",
    uri = "spotify:playlist:1"
)
