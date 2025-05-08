package and.degilevich.dream.shared.core.service.api.requests.getArtistRelatedArtists

import and.degilevich.dream.shared.core.service.api.core.artist.ArtistOutput
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetArtistRelatedArtistsResponse(
    @SerialName("artists")
    val artists: List<ArtistOutput>?
)