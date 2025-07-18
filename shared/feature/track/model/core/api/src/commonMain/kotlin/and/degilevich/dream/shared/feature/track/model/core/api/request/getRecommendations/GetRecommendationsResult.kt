package and.degilevich.dream.shared.feature.track.model.core.api.request.getRecommendations

import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData

data class GetRecommendationsResult(
    val tracks: List<TrackData>
)