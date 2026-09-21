package and.degilevich.dream.shared.feature.playlist.data.impl.remote

import and.degilevich.dream.shared.core.service.api.ApiService
import and.degilevich.dream.shared.core.service.api.generated.api.PlaylistsApi
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote.PlaylistOutputToDataMapper
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote.PlaylistTracksResponseToResultMapper
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote.SimplifiedPlaylistOutputToDataMapper
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsResult
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylist.GetPlaylistParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylist.GetPlaylistResult
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class PlaylistRemoteDataSourceImpl(
    private val apiService: ApiService,
    private val simplifiedPlaylistOutputToDataMapper: SimplifiedPlaylistOutputToDataMapper,
    private val playlistOutputToDataMapper: PlaylistOutputToDataMapper,
    private val playlistTracksResponseToResultMapper: PlaylistTracksResponseToResultMapper
) : PlaylistRemoteDataSource {

    private val playlistsApi: PlaylistsApi by lazy { apiService.playlistsApi }

    override suspend fun getCurrentUserPlaylists(
        params: GetCurrentUserPlaylistsParams
    ): Result<GetCurrentUserPlaylistsResult> = runCatching {
        playlistsApi.getAListOfCurrentUsersPlaylists(
            limit = params.limit,
            offset = params.offset
        ).body()
    }.map { response ->
        GetCurrentUserPlaylistsResult(
            playlists = response.items.mapWith(simplifiedPlaylistOutputToDataMapper)
        )
    }

    override suspend fun getPlaylist(params: GetPlaylistParams): Result<GetPlaylistResult> = runCatching {
        playlistsApi.getPlaylist(
            playlistId = params.id.value,
            fields = PLAYLIST_FIELDS
        ).body()
    }.map { response ->
        GetPlaylistResult(
            playlist = response.mapWith(playlistOutputToDataMapper)
        )
    }

    override suspend fun getPlaylistTracks(
        params: GetPlaylistTracksParams
    ): Result<GetPlaylistTracksResult> = runCatching {
        playlistsApi.getPlaylistsItems(
            playlistId = params.id.value,
            limit = params.limit,
            offset = params.offset
        ).body()
    }.map { response ->
        response.mapWith(playlistTracksResponseToResultMapper)
    }

    private companion object {
        const val PLAYLIST_FIELDS = "id,name,description,images"
    }
}
