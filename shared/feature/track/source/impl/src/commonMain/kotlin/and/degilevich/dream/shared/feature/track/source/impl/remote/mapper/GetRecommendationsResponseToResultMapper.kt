package and.degilevich.dream.shared.feature.track.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.requests.getRecommendations.GetRecommendationsResponse
import and.degilevich.dream.shared.feature.track.model.core.api.mapper.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.source.api.remote.request.getRecommendations.GetRecommendationsResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class GetRecommendationsResponseToResultMapper(
    private val trackOutputToDataMapper: TrackOutputToDataMapper
) : Mapper<GetRecommendationsResponse, GetRecommendationsResult> {
    override fun map(item: GetRecommendationsResponse): GetRecommendationsResult {
        return with(item) {
            GetRecommendationsResult(
                tracks = tracks?.mapWith(trackOutputToDataMapper).orEmpty()
            )
        }
    }
}