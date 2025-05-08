package and.degilevich.dream.shared.core.service.api.requests.getNewReleases

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetNewReleasesRequest(
    @SerialName("limit")
    val limit: Int,
    @SerialName("offset")
    val offset: Int
)