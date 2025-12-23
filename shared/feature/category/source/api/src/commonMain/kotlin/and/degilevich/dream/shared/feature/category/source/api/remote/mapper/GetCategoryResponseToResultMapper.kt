package and.degilevich.dream.shared.feature.category.source.api.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getCategory.GetCategoryResponse
import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategory.GetCategoryResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetCategoryResponseToResultMapper : Mapper<GetCategoryResponse, GetCategoryResult>