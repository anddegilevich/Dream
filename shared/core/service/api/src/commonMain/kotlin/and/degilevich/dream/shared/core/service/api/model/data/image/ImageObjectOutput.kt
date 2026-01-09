package and.degilevich.dream.shared.core.service.api.model.data.image

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageObjectOutput(

    @SerialName("url")
    val url: String?,

    @SerialName("height")
    val height: String?,

    @SerialName("width")
    val width: String?,
)
