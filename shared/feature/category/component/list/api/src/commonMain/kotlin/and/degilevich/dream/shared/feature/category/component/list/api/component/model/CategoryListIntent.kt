package and.degilevich.dream.shared.feature.category.component.list.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.id.Identifier

sealed interface CategoryListIntent {
    data class OnCategoryClicked(val id: Identifier) : CategoryListIntent
}