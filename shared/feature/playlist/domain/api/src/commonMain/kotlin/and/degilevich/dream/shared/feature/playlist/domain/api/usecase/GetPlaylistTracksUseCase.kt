package and.degilevich.dream.shared.feature.playlist.domain.api.usecase

import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksResult

interface GetPlaylistTracksUseCase {
    suspend operator fun invoke(params: GetPlaylistTracksParams): Result<GetPlaylistTracksResult>
}
