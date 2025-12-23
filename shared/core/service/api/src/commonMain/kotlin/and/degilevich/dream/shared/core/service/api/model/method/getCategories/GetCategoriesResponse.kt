package and.degilevich.dream.shared.core.service.api.model.method.getCategories

import and.degilevich.dream.shared.core.service.api.model.data.category.CategoryOutput
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetCategoriesResponse(
    @SerialName("items")
    val items: List<CategoryOutput>?,
)