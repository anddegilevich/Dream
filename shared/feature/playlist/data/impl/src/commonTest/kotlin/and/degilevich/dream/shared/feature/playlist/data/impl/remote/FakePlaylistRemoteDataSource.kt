package and.degilevich.dream.shared.feature.playlist.data.impl.remote

import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsResult
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylist.GetPlaylistParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylist.GetPlaylistResult
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakePlaylistRemoteDataSource(
    private val onGetCurrentUserPlaylists: (GetCurrentUserPlaylistsParams) -> Result<GetCurrentUserPlaylistsResult> = {
        fakeImplementationError()
    },
    private val onGetPlaylist: (GetPlaylistParams) -> Result<GetPlaylistResult> = { fakeImplementationError() },
    private val onGetPlaylistTracks: (GetPlaylistTracksParams) -> Result<GetPlaylistTracksResult> = {
        fakeImplementationError()
    }
) : PlaylistRemoteDataSource {

    override suspend fun getCurrentUserPlaylists(
        params: GetCurrentUserPlaylistsParams
    ): Result<GetCurrentUserPlaylistsResult> {
        return onGetCurrentUserPlaylists(params)
    }

    override suspend fun getPlaylist(params: GetPlaylistParams): Result<GetPlaylistResult> = onGetPlaylist(params)

    override suspend fun getPlaylistTracks(
        params: GetPlaylistTracksParams
    ): Result<GetPlaylistTracksResult> = onGetPlaylistTracks(params)
}
