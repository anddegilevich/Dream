package and.degilevich.dream.shared.feature.category.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getCategory.GetCategoryRequest
import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategory.GetCategoryParams
import and.degilevich.dream.shared.feature.category.source.api.remote.mapper.GetCategoryParamsToRequestMapper

internal class GetCategoryParamsToRequestMapperImpl : GetCategoryParamsToRequestMapper {

    override fun map(item: GetCategoryParams): GetCategoryRequest = with(item) {
        GetCategoryRequest(
            categoryId = id
        )
    }
}