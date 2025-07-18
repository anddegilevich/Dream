package and.degilevich.dream.shared.feature.track.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.requests.getRecommendations.GetRecommendationsResponse
import and.degilevich.dream.shared.feature.track.model.core.api.mapper.GetRecommendationsResponseToResultMapper
import and.degilevich.dream.shared.feature.track.model.core.api.mapper.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.core.api.request.getRecommendations.GetRecommendationsResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class GetRecommendationsResponseToResultMapperImpl(
    private val trackOutputToDataMapper: TrackOutputToDataMapper
) : GetRecommendationsResponseToResultMapper {
    override fun map(item: GetRecommendationsResponse): GetRecommendationsResult {
        return with(item) {
            GetRecommendationsResult(
                tracks = tracks?.mapWith(trackOutputToDataMapper).orEmpty()
            )
        }
    }
}