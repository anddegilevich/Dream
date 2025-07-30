package and.degilevich.dream.shared.feature.search.source.api.remote

import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchResult

interface SearchRemoteDataSource {
    suspend fun search(params: SearchParams): Result<SearchResult>
}