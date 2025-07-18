package and.degilevich.dream.shared.feature.search.domain.api.usecase

import and.degilevich.dream.shared.feature.search.model.core.api.request.search.SearchParams
import and.degilevich.dream.shared.feature.search.model.core.api.request.search.SearchResult

interface SearchUseCase {
    suspend operator fun invoke(params: SearchParams): Result<SearchResult>
}