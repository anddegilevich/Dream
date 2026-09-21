package and.degilevich.dream.shared.feature.search.domain.impl.usecase

import and.degilevich.dream.shared.feature.search.data.api.repository.SearchRepository
import and.degilevich.dream.shared.feature.search.domain.api.usecase.SearchUseCase
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchResult

internal class SearchUseCaseImpl(
    private val searchRepository: SearchRepository
) : SearchUseCase {

    override suspend fun invoke(params: SearchParams): Result<SearchResult> {
        return searchRepository.search(params = params)
    }
}
