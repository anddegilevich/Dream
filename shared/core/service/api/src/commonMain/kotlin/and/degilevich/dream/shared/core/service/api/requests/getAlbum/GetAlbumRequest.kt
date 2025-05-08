package and.degilevich.dream.shared.core.service.api.requests.getAlbum

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetAlbumRequest(
    @SerialName("id")
    val id: String
)