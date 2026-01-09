package and.degilevich.dream.shared.core.service.api.model.method.search

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchRequest(

    @SerialName("q")
    val q: String,

    @SerialName("limit")
    val limit: Int,

    @SerialName("offset")
    val offset: Int,

    @SerialName("type")
    val type: List<String>?
)
