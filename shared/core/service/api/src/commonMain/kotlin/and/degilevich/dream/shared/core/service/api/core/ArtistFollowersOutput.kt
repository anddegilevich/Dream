package and.degilevich.dream.shared.core.service.api.core

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtistFollowersOutput(
    @SerialName("total")
    val total: Int?
)