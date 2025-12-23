package and.degilevich.dream.shared.feature.category.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getCategories.GetCategoriesRequest
import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategories.GetCategoriesParams
import and.degilevich.dream.shared.feature.category.source.api.remote.mapper.GetCategoriesParamsToRequestMapper

internal class GetCategoriesParamsToRequestMapperImpl : GetCategoriesParamsToRequestMapper {

    override fun map(item: GetCategoriesParams): GetCategoriesRequest = with(item) {
        GetCategoriesRequest(
            limit = limit,
            offset = offset
        )
    }
}