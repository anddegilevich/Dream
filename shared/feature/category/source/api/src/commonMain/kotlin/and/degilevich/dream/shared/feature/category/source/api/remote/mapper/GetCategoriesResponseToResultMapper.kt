package and.degilevich.dream.shared.feature.category.source.api.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getCategories.GetCategoriesResponse
import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategories.GetCategoriesResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface GetCategoriesResponseToResultMapper : Mapper<GetCategoriesResponse, GetCategoriesResult>