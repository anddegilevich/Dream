package and.degilevich.dream.shared.core.service.api.model.method.getArtists

import and.degilevich.dream.shared.core.service.api.model.data.artist.ArtistOutput
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetArtistsResponse(

    @SerialName("artists")
    val artists: List<ArtistOutput>?
)
