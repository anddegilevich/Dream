package and.degilevich.dream.shared.core.service.api.model.method.getRecommendations

import and.degilevich.dream.shared.core.service.api.model.data.track.TrackOutput
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetRecommendationsResponse(

    @SerialName("tracks")
    val tracks: List<TrackOutput>?
)