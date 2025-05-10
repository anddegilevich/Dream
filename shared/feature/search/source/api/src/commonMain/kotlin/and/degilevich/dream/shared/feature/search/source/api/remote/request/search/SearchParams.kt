package and.degilevich.dream.shared.feature.search.source.api.remote.request.search

import and.degilevich.dream.shared.feature.search.model.core.api.dictionary.SearchType

data class SearchParams(
    val query: String,
    val limit: Int,
    val offset: Int,
    val types: List<SearchType>
)
