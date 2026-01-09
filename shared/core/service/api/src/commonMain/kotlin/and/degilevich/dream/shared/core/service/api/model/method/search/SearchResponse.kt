package and.degilevich.dream.shared.core.service.api.model.method.search

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(

    @SerialName("tracks")
    val tracks: SearchTracksOutput?,

    @SerialName("artists")
    val artists: SearchArtistsOutput?,

    @SerialName("albums")
    val albums: SearchAlbumsOutput?,
)
