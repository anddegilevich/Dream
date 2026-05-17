package and.degilevich.dream.shared.feature.search.component.search.impl.component.model

import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchResult
import kotlinx.serialization.Serializable

@Serializable
data class SearchState(
    val isLoading: Boolean,
    val searchResult: SearchResult,
    val query: String
)