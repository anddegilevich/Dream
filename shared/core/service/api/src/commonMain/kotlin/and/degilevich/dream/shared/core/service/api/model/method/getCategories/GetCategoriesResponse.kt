package and.degilevich.dream.shared.core.service.api.model.method.getCategories

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetCategoriesResponse(

    @SerialName("categories")
    val categories: CategoriesOutput?,
)