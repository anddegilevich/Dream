package and.degilevich.dream.shared.feature.playlist.domain.impl.usecase

import and.degilevich.dream.shared.feature.playlist.data.api.repository.PlaylistRepository
import and.degilevich.dream.shared.feature.playlist.domain.api.usecase.GetPlaylistUseCase
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylist.GetPlaylistParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylist.GetPlaylistResult

internal class GetPlaylistUseCaseImpl(
    private val playlistRepository: PlaylistRepository
) : GetPlaylistUseCase {

    override suspend fun invoke(params: GetPlaylistParams): Result<GetPlaylistResult> {
        return playlistRepository.getPlaylist(params = params)
    }
}
