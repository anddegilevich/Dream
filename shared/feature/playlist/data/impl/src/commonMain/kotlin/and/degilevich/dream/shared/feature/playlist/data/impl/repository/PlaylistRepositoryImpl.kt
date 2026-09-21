package and.degilevich.dream.shared.feature.playlist.data.impl.repository

import and.degilevich.dream.shared.feature.playlist.data.api.repository.PlaylistRepository
import and.degilevich.dream.shared.feature.playlist.data.impl.local.PlaylistLocalDataSource
import and.degilevich.dream.shared.feature.playlist.data.impl.remote.PlaylistRemoteDataSource
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.SimplifiedPlaylistData
import and.degilevich.dream.shared.feature.playlist.model.core.api.data.PlaylistData
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsResult
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylist.GetPlaylistParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylist.GetPlaylistResult
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksResult

internal class PlaylistRepositoryImpl(
    private val playlistRemoteDataSource: PlaylistRemoteDataSource,
    private val playlistLocalDataSource: PlaylistLocalDataSource
) : PlaylistRepository {

    override suspend fun getCurrentUserPlaylists(
        params: GetCurrentUserPlaylistsParams
    ): Result<GetCurrentUserPlaylistsResult> {
        return playlistRemoteDataSource.getCurrentUserPlaylists(params = params)
    }

    override suspend fun getPlaylist(params: GetPlaylistParams): Result<GetPlaylistResult> {
        return playlistRemoteDataSource.getPlaylist(params = params)
    }

    override suspend fun getPlaylistTracks(
        params: GetPlaylistTracksParams
    ): Result<GetPlaylistTracksResult> {
        return playlistRemoteDataSource.getPlaylistTracks(params = params)
    }

    override suspend fun cachePlaylist(playlist: PlaylistData) {
        playlistLocalDataSource.savePlaylist(playlist = playlist)
    }

    override suspend fun cachePlaylists(playlists: List<SimplifiedPlaylistData>) {
        playlistLocalDataSource.savePlaylists(playlists = playlists)
    }
}
