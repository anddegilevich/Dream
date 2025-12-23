package and.degilevich.dream.shared.feature.category.domain.api.usecase

import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategory.GetCategoryParams
import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategory.GetCategoryResult

interface FetchCategoryUseCase {
    suspend operator fun invoke(params: GetCategoryParams): Result<GetCategoryResult>
}