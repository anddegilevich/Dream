package and.degilevich.dream.shared.feature.playlist.data.impl.remote

import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakePlaylistRemoteDataSource(
    private val onGetCurrentUserPlaylists: (GetCurrentUserPlaylistsParams) -> Result<GetCurrentUserPlaylistsResult> = {
        fakeImplementationError()
    }
) : PlaylistRemoteDataSource {

    override suspend fun getCurrentUserPlaylists(
        params: GetCurrentUserPlaylistsParams
    ): Result<GetCurrentUserPlaylistsResult> {
        return onGetCurrentUserPlaylists(params)
    }
}
