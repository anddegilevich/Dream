package and.degilevich.dream.shared.feature.track.source.api.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getRecommendations.GetRecommendationsResponse
import and.degilevich.dream.shared.feature.track.model.core.api.method.getRecommendations.GetRecommendationsResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetRecommendationsResponseToResultMapper : Mapper<GetRecommendationsResponse, GetRecommendationsResult>