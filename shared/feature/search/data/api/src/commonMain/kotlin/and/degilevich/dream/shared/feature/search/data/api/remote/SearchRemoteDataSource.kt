package and.degilevich.dream.shared.feature.search.data.api.remote

import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchResult

interface SearchRemoteDataSource {
    suspend fun search(params: SearchParams): Result<SearchResult>
}