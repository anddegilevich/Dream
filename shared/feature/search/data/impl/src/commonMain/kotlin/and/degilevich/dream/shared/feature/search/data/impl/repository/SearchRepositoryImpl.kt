package and.degilevich.dream.shared.feature.search.data.impl.repository

import and.degilevich.dream.shared.feature.search.data.api.repository.SearchRepository
import and.degilevich.dream.shared.feature.search.data.impl.remote.SearchRemoteDataSource
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchResult

internal class SearchRepositoryImpl(
    private val searchRemoteDataSource: SearchRemoteDataSource
) : SearchRepository {

    override suspend fun search(params: SearchParams): Result<SearchResult> {
        return searchRemoteDataSource.search(params = params)
    }
}
