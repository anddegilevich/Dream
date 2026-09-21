package and.degilevich.dream.shared.feature.search.component.search.impl.component.model

import and.degilevich.dream.shared.feature.search.model.core.api.data.SearchItemData
import kotlinx.serialization.Serializable

@Serializable
data class SearchState(
    val isLoading: Boolean,
    val items: List<SearchItemData>,
    val query: String
)
