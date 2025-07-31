package and.degilevich.dream.shared.core.service.api.model.method.search

import and.degilevich.dream.shared.core.service.api.model.data.album.AlbumSimplifiedOutput
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchAlbumsOutput(
    @SerialName("items")
    val items: List<AlbumSimplifiedOutput>?
)