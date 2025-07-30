package and.degilevich.dream.shared.feature.search.domain.api.usecase

import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchResult

interface SearchUseCase {
    suspend operator fun invoke(params: SearchParams): Result<SearchResult>
}