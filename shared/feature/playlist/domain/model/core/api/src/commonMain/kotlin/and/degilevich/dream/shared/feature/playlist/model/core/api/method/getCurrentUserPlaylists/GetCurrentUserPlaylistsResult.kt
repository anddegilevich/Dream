package and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists

import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.SimplifiedPlaylistData

data class GetCurrentUserPlaylistsResult(
    val playlists: List<SimplifiedPlaylistData>
)
