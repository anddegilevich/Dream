package and.degilevich.dream.shared.feature.category.domain.impl.usecase

import and.degilevich.dream.shared.feature.category.domain.api.usecase.FetchCategoriesUseCase
import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategories.GetCategoriesParams
import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategories.GetCategoriesResult
import and.degilevich.dream.shared.feature.category.source.api.remote.CategoryRemoteDataSource

internal class FetchCategoriesUseCaseImpl(
    private val categoryRemoteDataSource: CategoryRemoteDataSource
) : FetchCategoriesUseCase {

    override suspend fun invoke(params: GetCategoriesParams): Result<GetCategoriesResult> {
        return categoryRemoteDataSource.getCategories(params)
    }
}