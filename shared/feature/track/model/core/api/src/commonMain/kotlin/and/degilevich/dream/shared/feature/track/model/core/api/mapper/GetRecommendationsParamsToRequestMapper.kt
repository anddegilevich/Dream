package and.degilevich.dream.shared.feature.track.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getRecommendations.GetRecommendationsRequest
import and.degilevich.dream.shared.feature.track.model.core.api.method.getRecommendations.GetRecommendationsParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetRecommendationsParamsToRequestMapper : Mapper<GetRecommendationsParams, GetRecommendationsRequest>