package and.degilevich.dream.shared.feature.category.model.core.api.method.getCategories

import and.degilevich.dream.shared.feature.category.model.core.api.data.CategoryData

data class GetCategoriesResult(
    val categories: List<CategoryData>
)