package and.degilevich.dream.shared.feature.playlist.domain.api.usecase

import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsResult

interface GetCurrentUserPlaylistsUseCase {
    suspend operator fun invoke(params: GetCurrentUserPlaylistsParams): Result<GetCurrentUserPlaylistsResult>
}
