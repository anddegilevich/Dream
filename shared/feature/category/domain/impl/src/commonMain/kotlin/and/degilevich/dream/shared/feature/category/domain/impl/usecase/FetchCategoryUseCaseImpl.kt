package and.degilevich.dream.shared.feature.category.domain.impl.usecase

import and.degilevich.dream.shared.feature.category.domain.api.usecase.FetchCategoryUseCase
import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategory.GetCategoryParams
import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategory.GetCategoryResult
import and.degilevich.dream.shared.feature.category.source.api.remote.CategoryRemoteDataSource

internal class FetchCategoryUseCaseImpl(
    private val categoryRemoteDataSource: CategoryRemoteDataSource
) : FetchCategoryUseCase {

    override suspend fun invoke(params: GetCategoryParams): Result<GetCategoryResult> {
        return categoryRemoteDataSource.getCategory(params)
    }
}