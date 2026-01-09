package and.degilevich.dream.shared.feature.category.component.list.api.preview.component

import and.degilevich.dream.shared.feature.category.component.list.api.component.CategoryListComponent
import and.degilevich.dream.shared.feature.category.component.list.api.component.model.CategoryListIntent
import and.degilevich.dream.shared.feature.category.component.list.api.component.model.CategoryListSideEffect
import and.degilevich.dream.shared.feature.category.component.list.api.component.model.CategoryListUIState
import and.degilevich.dream.shared.feature.category.component.list.api.preview.provider.CategoryListUIStatePreviewProvider
import and.degilevich.dream.shared.foundation.decompose.preview.PreviewMVIComponent

class CategoryListPreviewComponent :
    PreviewMVIComponent<CategoryListUIState, CategoryListIntent, CategoryListSideEffect>(
        state = CategoryListUIStatePreviewProvider().provide()
    ),
    CategoryListComponent