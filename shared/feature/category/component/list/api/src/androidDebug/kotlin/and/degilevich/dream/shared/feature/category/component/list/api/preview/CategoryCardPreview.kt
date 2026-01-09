package and.degilevich.dream.shared.feature.category.component.list.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.category.component.list.api.component.model.CategoryCardUIData
import and.degilevich.dream.shared.feature.category.component.list.api.design.CategoryCard
import and.degilevich.dream.shared.feature.category.component.list.api.preview.provider.CategoryCardUIDataPreviewProvider
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter

@PreviewLightDark
@Composable
private fun CategoryCardPreview(
    @PreviewParameter(CategoryCardUIDataPreviewProvider::class)
    data: CategoryCardUIData
) {
    ComposeAppTheme {
        CategoryCard(
            data = data
        ) {}
    }
}