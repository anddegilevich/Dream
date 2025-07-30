package and.degilevich.dream.shared.feature.track.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getRecommendations.GetRecommendationsRequest
import and.degilevich.dream.shared.feature.track.model.core.api.mapper.GetRecommendationsParamsToRequestMapper
import and.degilevich.dream.shared.feature.track.model.core.api.method.getRecommendations.GetRecommendationsParams

internal class GetRecommendationsParamsToRequestMapperImpl : GetRecommendationsParamsToRequestMapper {
    override fun map(item: GetRecommendationsParams): GetRecommendationsRequest {
        return with(item) {
            GetRecommendationsRequest(
                limit = limit
            )
        }
    }
}