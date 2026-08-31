package and.degilevich.dream.shared.feature.playlist.data.impl.remote

import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsResult

internal interface PlaylistRemoteDataSource {
    suspend fun getCurrentUserPlaylists(params: GetCurrentUserPlaylistsParams): Result<GetCurrentUserPlaylistsResult>
}
