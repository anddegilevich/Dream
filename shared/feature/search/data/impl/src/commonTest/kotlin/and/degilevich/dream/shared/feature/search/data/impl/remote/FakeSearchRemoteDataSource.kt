package and.degilevich.dream.shared.feature.search.data.impl.remote

import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeSearchRemoteDataSource(
    private val onSearch: (SearchParams) -> Result<SearchResult> = { fakeImplementationError() }
) : SearchRemoteDataSource {

    override suspend fun search(params: SearchParams): Result<SearchResult> = onSearch(params)
}
