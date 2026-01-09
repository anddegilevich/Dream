package and.degilevich.dream.shared.feature.category.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getCategories.GetCategoriesResponse
import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategories.GetCategoriesResult
import and.degilevich.dream.shared.feature.category.source.api.remote.mapper.CategoryOutputToDataMapper
import and.degilevich.dream.shared.feature.category.source.api.remote.mapper.GetCategoriesResponseToResultMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class GetCategoriesResponseToResultMapperImpl(
    private val categoryOutputToDataMapper: CategoryOutputToDataMapper
) : GetCategoriesResponseToResultMapper {

    override fun map(item: GetCategoriesResponse): GetCategoriesResult = with(item) {
        GetCategoriesResult(
            categories = categories?.items?.mapWith(categoryOutputToDataMapper).orEmpty()
        )
    }
}