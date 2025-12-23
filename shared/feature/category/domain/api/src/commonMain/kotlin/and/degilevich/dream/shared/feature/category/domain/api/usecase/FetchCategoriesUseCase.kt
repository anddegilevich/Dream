package and.degilevich.dream.shared.feature.category.domain.api.usecase

import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategories.GetCategoriesParams
import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategories.GetCategoriesResult

interface FetchCategoriesUseCase {
    suspend operator fun invoke(params: GetCategoriesParams): Result<GetCategoriesResult>
}