package and.degilevich.dream.shared.core.service.api.model.data.artist

import and.degilevich.dream.shared.core.service.api.model.data.image.ImageObjectOutput
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtistOutput(

    @SerialName("id")
    val id: String? = null,

    @SerialName("name")
    val name: String? = null,

    @SerialName("type")
    val type: String? = null,

    @SerialName("images")
    val images: List<ImageObjectOutput>? = null
)