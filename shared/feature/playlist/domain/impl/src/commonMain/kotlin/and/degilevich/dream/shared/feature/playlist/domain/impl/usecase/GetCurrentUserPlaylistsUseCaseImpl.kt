package and.degilevich.dream.shared.feature.playlist.domain.impl.usecase

import and.degilevich.dream.shared.feature.playlist.data.api.repository.PlaylistRepository
import and.degilevich.dream.shared.feature.playlist.domain.api.usecase.GetCurrentUserPlaylistsUseCase
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsResult

internal class GetCurrentUserPlaylistsUseCaseImpl(
    private val playlistRepository: PlaylistRepository
) : GetCurrentUserPlaylistsUseCase {

    override suspend fun invoke(
        params: GetCurrentUserPlaylistsParams
    ): Result<GetCurrentUserPlaylistsResult> {
        return playlistRepository.getCurrentUserPlaylists(params = params)
            .onSuccess { result ->
                playlistRepository.cachePlaylists(playlists = result.playlists)
            }
    }
}
