package and.degilevich.dream.shared.feature.category.source.api.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getCategory.GetCategoryRequest
import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategory.GetCategoryParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetCategoryParamsToRequestMapper : Mapper<GetCategoryParams, GetCategoryRequest>