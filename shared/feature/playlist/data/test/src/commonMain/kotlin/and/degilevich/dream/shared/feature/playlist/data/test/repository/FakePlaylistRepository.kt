package and.degilevich.dream.shared.feature.playlist.data.test.repository

import and.degilevich.dream.shared.feature.playlist.data.api.repository.PlaylistRepository
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakePlaylistRepository(
    private val onGetCurrentUserPlaylists: (
        params: GetCurrentUserPlaylistsParams
    ) -> Result<GetCurrentUserPlaylistsResult> = { fakeImplementationError() }
) : PlaylistRepository {

    override suspend fun getCurrentUserPlaylists(
        params: GetCurrentUserPlaylistsParams
    ): Result<GetCurrentUserPlaylistsResult> = onGetCurrentUserPlaylists(params)
}
