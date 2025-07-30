package and.degilevich.dream.shared.core.service.api.model.method.getArtists

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetArtistsRequest(
    @SerialName("ids")
    val ids: String
)