package and.degilevich.dream.shared.feature.track.domain.api.usecase

import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackResult

interface FetchTrackUseCase {
    suspend operator fun invoke(params: GetTrackParams): Result<GetTrackResult>
}