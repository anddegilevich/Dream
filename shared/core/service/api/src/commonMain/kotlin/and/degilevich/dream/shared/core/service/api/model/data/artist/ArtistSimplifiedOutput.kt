package and.degilevich.dream.shared.core.service.api.model.data.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtistSimplifiedOutput(

    @SerialName("id")
    val id: String? = null,

    @SerialName("name")
    val name: String? = null,

    @SerialName("type")
    val artistType: String? = null
)