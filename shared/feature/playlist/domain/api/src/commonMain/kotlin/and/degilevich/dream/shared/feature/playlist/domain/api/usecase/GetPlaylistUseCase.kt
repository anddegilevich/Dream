package and.degilevich.dream.shared.feature.playlist.domain.api.usecase

import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylist.GetPlaylistParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylist.GetPlaylistResult

interface GetPlaylistUseCase {
    suspend operator fun invoke(params: GetPlaylistParams): Result<GetPlaylistResult>
}
