package and.degilevich.dream.shared.core.service.api.requests.getRecommendations

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetRecommendationsRequest(
    @SerialName("limit")
    val limit: Int
)
