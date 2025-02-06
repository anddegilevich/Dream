package and.degilevich.dream.shared.core.service.api.requests.getArtists

import and.degilevich.dream.shared.core.service.api.core.ArtistOutput
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetArtistsResponse(
    @SerialName("artists")
    val artists: List<ArtistOutput>?
)
