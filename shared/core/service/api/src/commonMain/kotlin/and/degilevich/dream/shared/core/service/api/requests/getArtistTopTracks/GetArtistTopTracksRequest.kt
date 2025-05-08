package and.degilevich.dream.shared.core.service.api.requests.getArtistTopTracks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetArtistTopTracksRequest(
    @SerialName("id")
    val id: String
)