package and.degilevich.dream.shared.feature.category.component.list.api.preview.skeleton

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.category.component.list.api.design.skeleton.SkeletonCategoryCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark

@PreviewLightDark
@Composable
private fun SkeletonCategoryCardPreview() {
    ComposeAppTheme {
        SkeletonCategoryCard(
            modifier = Modifier.themeBackground()
        )
    }
}