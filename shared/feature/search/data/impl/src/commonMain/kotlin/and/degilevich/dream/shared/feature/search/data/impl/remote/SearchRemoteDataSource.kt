package and.degilevich.dream.shared.feature.search.data.impl.remote

import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchResult

internal interface SearchRemoteDataSource {
    suspend fun search(params: SearchParams): Result<SearchResult>
}