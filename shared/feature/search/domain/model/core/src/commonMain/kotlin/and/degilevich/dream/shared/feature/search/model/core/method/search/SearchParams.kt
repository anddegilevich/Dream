package and.degilevich.dream.shared.feature.search.model.core.method.search

import and.degilevich.dream.shared.feature.search.model.core.dictionary.SearchType

data class SearchParams(
    val query: String,
    val limit: Int,
    val offset: Int,
    val types: List<SearchType>
)
