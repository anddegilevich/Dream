package and.degilevich.dream.shared.feature.track.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.requests.getRecommendations.GetRecommendationsResponse
import and.degilevich.dream.shared.feature.track.model.core.api.request.getRecommendations.GetRecommendationsResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetRecommendationsResponseToResultMapper : Mapper<GetRecommendationsResponse, GetRecommendationsResult>