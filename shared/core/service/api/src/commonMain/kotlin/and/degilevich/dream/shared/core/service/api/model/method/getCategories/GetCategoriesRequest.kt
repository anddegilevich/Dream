package and.degilevich.dream.shared.core.service.api.model.method.getCategories

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetCategoriesRequest(
    @SerialName("limit")
    val limit: Int,
    @SerialName("offset")
    val offset: Int
)