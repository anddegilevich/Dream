package and.degilevich.dream.shared.feature.category.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getCategory.GetCategoryResponse
import and.degilevich.dream.shared.feature.category.model.core.api.data.CategoryData
import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategory.GetCategoryResult
import and.degilevich.dream.shared.feature.category.source.api.remote.mapper.CategoryOutputToDataMapper
import and.degilevich.dream.shared.feature.category.source.api.remote.mapper.GetCategoryResponseToResultMapper
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class GetCategoryResponseToResultMapperImpl(
    private val categoryOutputToDataMapper: CategoryOutputToDataMapper
) : GetCategoryResponseToResultMapper {

    override fun map(item: GetCategoryResponse): GetCategoryResult = with(item) {
        GetCategoryResult(
            category = this?.mapWith(categoryOutputToDataMapper).orEmpty(CategoryData)
        )
    }
}