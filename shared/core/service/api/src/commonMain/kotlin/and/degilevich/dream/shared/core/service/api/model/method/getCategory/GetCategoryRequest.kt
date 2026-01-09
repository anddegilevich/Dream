package and.degilevich.dream.shared.core.service.api.model.method.getCategory

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetCategoryRequest(

    @SerialName("category_id")
    val categoryId: String
)