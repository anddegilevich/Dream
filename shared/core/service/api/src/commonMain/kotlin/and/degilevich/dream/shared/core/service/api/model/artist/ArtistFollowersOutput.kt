package and.degilevich.dream.shared.core.service.api.model.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtistFollowersOutput(
    @SerialName("total")
    val total: Int?
)