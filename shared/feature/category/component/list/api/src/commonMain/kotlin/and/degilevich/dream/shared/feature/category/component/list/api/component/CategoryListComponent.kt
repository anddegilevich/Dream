package and.degilevich.dream.shared.feature.category.component.list.api.component

import and.degilevich.dream.shared.feature.category.component.list.api.component.model.CategoryListIntent
import and.degilevich.dream.shared.feature.category.component.list.api.component.model.CategoryListSideEffect
import and.degilevich.dream.shared.feature.category.component.list.api.component.model.CategoryListUIState
import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent
import androidx.compose.runtime.Stable

@Stable
interface CategoryListComponent : MVIComponent<CategoryListUIState, CategoryListIntent, CategoryListSideEffect>