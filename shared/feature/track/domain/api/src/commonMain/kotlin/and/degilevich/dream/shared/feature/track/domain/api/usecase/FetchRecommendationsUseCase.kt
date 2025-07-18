package and.degilevich.dream.shared.feature.track.domain.api.usecase

import and.degilevich.dream.shared.feature.track.model.core.api.request.getRecommendations.GetRecommendationsParams
import and.degilevich.dream.shared.feature.track.model.core.api.request.getRecommendations.GetRecommendationsResult

interface FetchRecommendationsUseCase {
    suspend operator fun invoke(params: GetRecommendationsParams): Result<GetRecommendationsResult>
}