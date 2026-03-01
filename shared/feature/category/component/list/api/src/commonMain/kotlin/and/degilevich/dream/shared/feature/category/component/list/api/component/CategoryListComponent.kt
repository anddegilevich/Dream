package and.degilevich.dream.shared.feature.category.component.list.api.component

import and.degilevich.dream.shared.feature.category.component.list.api.component.model.CategoryListIntent
import and.degilevich.dream.shared.feature.category.component.list.api.component.model.CategoryListSideEffect
import and.degilevich.dream.shared.feature.category.component.list.api.component.model.CategoryListUIState
import and.degilevich.dream.shared.feature.category.component.list.api.design.CategoryListCarousel
import and.degilevich.dream.shared.foundation.decompose.component.render.RenderMVIComponent
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier

@Stable
interface CategoryListComponent : RenderMVIComponent<CategoryListUIState, CategoryListIntent, CategoryListSideEffect> {

    @Composable
    override fun Render(modifier: Modifier) {
        CategoryListCarousel(
            modifier = modifier,
            state = state(),
            onIntent = ::handleIntent
        )
    }
}