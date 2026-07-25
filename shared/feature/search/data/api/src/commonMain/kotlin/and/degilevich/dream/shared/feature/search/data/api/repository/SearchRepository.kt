package and.degilevich.dream.shared.feature.search.data.api.repository

import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchResult

interface SearchRepository {
    suspend fun search(params: SearchParams): Result<SearchResult>
}