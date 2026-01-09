package and.degilevich.dream.shared.feature.category.component.list.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.category.component.list.api.component.model.CategoryListUIState
import and.degilevich.dream.shared.feature.category.component.list.api.design.CategoryListCarousel
import and.degilevich.dream.shared.feature.category.component.list.api.preview.provider.CategoryListUIStatePreviewProvider
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter

@PreviewLightDark
@Composable
private fun CategoryListCarouselPreview(
    @PreviewParameter(CategoryListUIStatePreviewProvider::class)
    state: CategoryListUIState
) {
    ComposeAppTheme {
        CategoryListCarousel(
            state = state
        ) {}
    }
}