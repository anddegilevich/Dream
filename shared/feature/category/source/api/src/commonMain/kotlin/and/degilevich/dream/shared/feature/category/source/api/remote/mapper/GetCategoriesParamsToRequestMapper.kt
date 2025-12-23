package and.degilevich.dream.shared.feature.category.source.api.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getCategories.GetCategoriesRequest
import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategories.GetCategoriesParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetCategoriesParamsToRequestMapper : Mapper<GetCategoriesParams, GetCategoriesRequest>