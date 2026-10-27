package and.degilevich.dream.shared.feature.playlist.domain.model.core.api.method.getCurrentUserPlaylists

import and.degilevich.dream.shared.feature.playlist.domain.model.artifact.api.data.SimplifiedPlaylistData

data class GetCurrentUserPlaylistsResult(
    val playlists: List<SimplifiedPlaylistData>
)
