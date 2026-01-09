package and.degilevich.dream.shared.core.service.api.model.data.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtistFollowersOutput(

    @SerialName("total")
    val total: Int?
)