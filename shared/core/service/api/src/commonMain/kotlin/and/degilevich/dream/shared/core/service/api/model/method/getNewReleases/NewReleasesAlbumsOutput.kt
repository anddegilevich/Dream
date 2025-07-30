package and.degilevich.dream.shared.core.service.api.model.method.getNewReleases

import and.degilevich.dream.shared.core.service.api.model.data.album.AlbumSimplifiedOutput
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewReleasesAlbumsOutput(
    @SerialName("total")
    val total: Int?,
    @SerialName("items")
    val items: List<AlbumSimplifiedOutput>?
)