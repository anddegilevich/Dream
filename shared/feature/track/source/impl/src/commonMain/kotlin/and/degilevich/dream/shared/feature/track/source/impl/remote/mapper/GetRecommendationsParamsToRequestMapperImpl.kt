package and.degilevich.dream.shared.feature.track.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getRecommendations.GetRecommendationsRequest
import and.degilevich.dream.shared.feature.track.model.core.api.method.getRecommendations.GetRecommendationsParams
import and.degilevich.dream.shared.feature.track.source.api.remote.mapper.GetRecommendationsParamsToRequestMapper

internal class GetRecommendationsParamsToRequestMapperImpl : GetRecommendationsParamsToRequestMapper {

    override fun map(item: GetRecommendationsParams): GetRecommendationsRequest {
        return with(item) {
            GetRecommendationsRequest(
                limit = limit
            )
        }
    }
}