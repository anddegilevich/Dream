package and.degilevich.dream.shared.core.service.api.model.method.getTrack

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetTrackRequest(
    @SerialName("id")
    val id: String
)
