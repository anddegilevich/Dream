package and.degilevich.dream.shared.feature.category.source.api.remote

import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategories.GetCategoriesParams
import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategories.GetCategoriesResult
import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategory.GetCategoryParams
import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategory.GetCategoryResult

interface CategoryRemoteDataSource {
    suspend fun getCategories(params: GetCategoriesParams): Result<GetCategoriesResult>
    suspend fun getCategory(params: GetCategoryParams): Result<GetCategoryResult>
}