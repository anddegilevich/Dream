package and.degilevich.dream.shared.feature.category.source.api.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.data.category.CategoryOutput
import and.degilevich.dream.shared.feature.category.model.core.api.data.CategoryData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface CategoryOutputToDataMapper : Mapper<CategoryOutput, CategoryData>