package and.degilevich.dream.shared.feature.playlist.data.api.repository

import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsResult

interface PlaylistRepository {
    suspend fun getCurrentUserPlaylists(params: GetCurrentUserPlaylistsParams): Result<GetCurrentUserPlaylistsResult>
}
