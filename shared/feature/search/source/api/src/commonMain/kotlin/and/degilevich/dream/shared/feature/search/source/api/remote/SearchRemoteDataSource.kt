package and.degilevich.dream.shared.feature.search.source.api.remote

import and.degilevich.dream.shared.feature.search.source.api.remote.request.search.SearchParams
import and.degilevich.dream.shared.feature.search.source.api.remote.request.search.SearchResult

interface SearchRemoteDataSource {
    suspend fun search(params: SearchParams): Result<SearchResult>
}