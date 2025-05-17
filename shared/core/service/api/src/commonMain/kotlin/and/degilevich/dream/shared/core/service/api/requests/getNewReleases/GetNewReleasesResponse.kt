package and.degilevich.dream.shared.core.service.api.requests.getNewReleases

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetNewReleasesResponse(
    @SerialName("albums")
    val albums: NewReleasesAlbumsOutput?,
)
