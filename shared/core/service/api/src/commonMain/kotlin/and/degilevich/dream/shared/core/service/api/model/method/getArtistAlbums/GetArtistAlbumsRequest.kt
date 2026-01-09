package and.degilevich.dream.shared.core.service.api.model.method.getArtistAlbums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetArtistAlbumsRequest(

    @SerialName("id")
    val id: String,

    @SerialName("limit")
    val limit: Int,

    @SerialName("offset")
    val offset: Int
)