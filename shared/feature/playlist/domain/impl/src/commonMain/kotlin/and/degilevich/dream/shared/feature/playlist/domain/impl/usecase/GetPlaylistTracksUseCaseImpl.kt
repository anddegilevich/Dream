package and.degilevich.dream.shared.feature.playlist.domain.impl.usecase

import and.degilevich.dream.shared.feature.playlist.data.api.repository.PlaylistRepository
import and.degilevich.dream.shared.feature.playlist.domain.api.usecase.GetPlaylistTracksUseCase
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksResult

internal class GetPlaylistTracksUseCaseImpl(
    private val playlistRepository: PlaylistRepository
) : GetPlaylistTracksUseCase {

    override suspend fun invoke(params: GetPlaylistTracksParams): Result<GetPlaylistTracksResult> {
        return playlistRepository.getPlaylistTracks(params = params)
    }
}
