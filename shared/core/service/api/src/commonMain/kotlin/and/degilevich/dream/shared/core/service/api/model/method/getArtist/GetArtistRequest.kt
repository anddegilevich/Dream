package and.degilevich.dream.shared.core.service.api.model.method.getArtist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetArtistRequest(
    @SerialName("id")
    val id: String
)