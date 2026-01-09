package and.degilevich.dream.shared.core.service.api.model.method.getArtistRelatedArtists

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetArtistRelatedArtistsRequest(

    @SerialName("id")
    val id: String
)
