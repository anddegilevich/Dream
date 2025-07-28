package and.degilevich.dream.shared.feature.search.component.search.impl.store.model

import kotlinx.serialization.Serializable

@Serializable
data class SearchState(
    val isLoading: Boolean,
    val query: String
)