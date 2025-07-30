package and.degilevich.dream.shared.core.service.api.model.method.getAlbum

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetAlbumRequest(
    @SerialName("id")
    val id: String
)