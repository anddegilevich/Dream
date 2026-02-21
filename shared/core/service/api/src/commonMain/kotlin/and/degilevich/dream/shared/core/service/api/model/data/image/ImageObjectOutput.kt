package and.degilevich.dream.shared.core.service.api.model.data.image

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageObjectOutput(

    @SerialName("url")
    val url: String? = null,

    @SerialName("height")
    val height: Int? = null,

    @SerialName("width")
    val width: Int? = null,
)
