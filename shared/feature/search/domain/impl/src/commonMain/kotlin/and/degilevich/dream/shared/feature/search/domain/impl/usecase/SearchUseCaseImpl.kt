package and.degilevich.dream.shared.feature.search.domain.impl.usecase

import and.degilevich.dream.shared.feature.search.domain.api.usecase.SearchUseCase
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchResult
import and.degilevich.dream.shared.feature.search.source.api.remote.SearchRemoteDataSource

internal class SearchUseCaseImpl(
    private val searchRemoteDataSource: SearchRemoteDataSource
) : SearchUseCase {
    override suspend fun invoke(params: SearchParams): Result<SearchResult> {
        return searchRemoteDataSource.search(params)
    }
}
