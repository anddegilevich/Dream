package and.degilevich.dream.shared.core.service.api.model.data.category

import and.degilevich.dream.shared.core.service.api.model.data.image.ImageObjectOutput
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryOutput(

    @SerialName("id")
    val id: String? = null,

    @SerialName("name")
    val name: String? = null,

    @SerialName("icons")
    val icons: List<ImageObjectOutput>? = null
)