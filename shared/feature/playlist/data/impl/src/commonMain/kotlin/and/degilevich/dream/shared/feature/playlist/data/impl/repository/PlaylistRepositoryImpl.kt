package and.degilevich.dream.shared.feature.playlist.data.impl.repository

import and.degilevich.dream.shared.feature.playlist.data.api.repository.PlaylistRepository
import and.degilevich.dream.shared.feature.playlist.data.impl.remote.PlaylistRemoteDataSource
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsResult

internal class PlaylistRepositoryImpl(
    private val playlistRemoteDataSource: PlaylistRemoteDataSource
) : PlaylistRepository {

    override suspend fun getCurrentUserPlaylists(
        params: GetCurrentUserPlaylistsParams
    ): Result<GetCurrentUserPlaylistsResult> {
        return playlistRemoteDataSource.getCurrentUserPlaylists(params = params)
    }
}
