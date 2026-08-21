package and.degilevich.dream.shared.feature.search.data.test.repository

import and.degilevich.dream.shared.feature.search.data.api.repository.SearchRepository
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeSearchRepository(
    private val onSearch: (SearchParams) -> Result<SearchResult> = { fakeImplementationError() }
) : SearchRepository {

    override suspend fun search(params: SearchParams): Result<SearchResult> = onSearch(params)
}