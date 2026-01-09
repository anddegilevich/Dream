package and.degilevich.dream.shared.feature.category.component.list.api.preview.provider

import and.degilevich.dream.shared.feature.category.component.list.api.component.model.CategoryListUIState
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class CategoryListUIStatePreviewProvider : PreviewParameterProvider<CategoryListUIState> {

    override val values: Sequence<CategoryListUIState> = sequenceOf(
        provideSkeleton(),
        provide()
    )

    fun provideSkeleton(): CategoryListUIState {
        return CategoryListUIState(
            categories = Skeleton.Loading
        )
    }

    fun provide(): CategoryListUIState {
        return CategoryListUIState(
            categories = Skeleton.Value(CategoryCardUIDataPreviewProvider().provideList())
        )
    }
}