package and.degilevich.dream.shared.feature.category.source.impl.remote

import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategories.GetCategoriesParams
import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategories.GetCategoriesResult
import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategory.GetCategoryParams
import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategory.GetCategoryResult
import and.degilevich.dream.shared.feature.category.source.api.remote.CategoryRemoteDataSource
import and.degilevich.dream.shared.feature.category.source.api.remote.mapper.GetCategoriesParamsToRequestMapper
import and.degilevich.dream.shared.feature.category.source.api.remote.mapper.GetCategoriesResponseToResultMapper
import and.degilevich.dream.shared.feature.category.source.api.remote.mapper.GetCategoryParamsToRequestMapper
import and.degilevich.dream.shared.feature.category.source.api.remote.mapper.GetCategoryResponseToResultMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess
import and.degilevich.dream.shared.template.source.impl.remote.BaseRemoteDataSource

internal class CategoryRemoteDataSourceImpl(
    private val getCategoriesParamsToRequestMapper: GetCategoriesParamsToRequestMapper,
    private val getCategoriesResponseToResultMapper: GetCategoriesResponseToResultMapper,
    private val getCategoryParamsToRequestMapper: GetCategoryParamsToRequestMapper,
    private val getCategoryResponseToResultMapper: GetCategoryResponseToResultMapper,
) : BaseRemoteDataSource(), CategoryRemoteDataSource {

    override suspend fun getCategories(params: GetCategoriesParams): Result<GetCategoriesResult> {
        return service.getCategories(
            request = params.mapWith(getCategoriesParamsToRequestMapper)
        ).foldResultSuccess { response ->
            response.mapWith(getCategoriesResponseToResultMapper)
        }
    }

    override suspend fun getCategory(params: GetCategoryParams): Result<GetCategoryResult> {
        return service.getCategory(
            request = params.mapWith(getCategoryParamsToRequestMapper)
        ).foldResultSuccess { response ->
            response.mapWith(getCategoryResponseToResultMapper)
        }
    }
}