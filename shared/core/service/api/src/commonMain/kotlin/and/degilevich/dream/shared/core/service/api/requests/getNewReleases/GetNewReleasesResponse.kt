package and.degilevich.dream.shared.core.service.api.requests.getNewReleases

import and.degilevich.dream.shared.core.service.api.core.album.AlbumOutput
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetNewReleasesResponse(
    @SerialName("total")
    val total: Int?,
    @SerialName("items")
    val items: List<AlbumOutput>?
)
