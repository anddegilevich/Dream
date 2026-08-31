package and.degilevich.dream.shared.feature.playlist.data.impl.remote

import and.degilevich.dream.shared.core.service.api.ApiService
import and.degilevich.dream.shared.core.service.api.generated.api.PlaylistsApi
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote.SimplifiedPlaylistOutputToDataMapper
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class PlaylistRemoteDataSourceImpl(
    private val apiService: ApiService,
    private val simplifiedPlaylistOutputToDataMapper: SimplifiedPlaylistOutputToDataMapper
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
}
