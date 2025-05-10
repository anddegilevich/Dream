package and.degilevich.dream.shared.feature.track.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.requests.getRecommendations.GetRecommendationsRequest
import and.degilevich.dream.shared.feature.track.source.api.remote.request.getRecommendations.GetRecommendationsParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

internal class GetRecommendationsParamsToRequestMapper : Mapper<GetRecommendationsParams, GetRecommendationsRequest> {
    override fun map(item: GetRecommendationsParams): GetRecommendationsRequest {
        return with(item) {
            GetRecommendationsRequest(
                limit = limit
            )
        }
    }
}