package and.degilevich.dream.shared.core.service.api.model.method.search

import and.degilevich.dream.shared.core.service.api.model.data.artist.ArtistOutput
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchArtistsOutput(

    @SerialName("items")
    val items: List<ArtistOutput>?
)
