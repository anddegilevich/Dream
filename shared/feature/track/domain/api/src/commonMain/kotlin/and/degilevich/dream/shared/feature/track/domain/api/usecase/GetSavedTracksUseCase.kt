package and.degilevich.dream.shared.feature.track.domain.api.usecase

import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksResult

interface GetSavedTracksUseCase {
    suspend operator fun invoke(params: GetSavedTracksParams): Result<GetSavedTracksResult>
}
