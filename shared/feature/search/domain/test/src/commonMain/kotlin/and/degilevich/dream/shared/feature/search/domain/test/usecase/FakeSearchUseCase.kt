package and.degilevich.dream.shared.feature.search.domain.test.usecase

import and.degilevich.dream.shared.feature.search.domain.api.usecase.SearchUseCase
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeSearchUseCase(
    private val onInvoke: suspend (params: SearchParams) -> Result<SearchResult> = {
        fakeImplementationError()
    }
) : SearchUseCase {

    override suspend fun invoke(params: SearchParams): Result<SearchResult> = onInvoke(params)
}
