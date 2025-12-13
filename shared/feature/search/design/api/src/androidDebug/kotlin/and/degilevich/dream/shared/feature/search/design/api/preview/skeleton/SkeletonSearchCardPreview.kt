package and.degilevich.dream.shared.feature.search.design.api.preview.skeleton

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.search.design.api.design.skeleton.SkeletonSearchCard
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@PreviewLightDark
@Composable
private fun SkeletonSearchCardPreview() {
    ComposeAppTheme {
        SkeletonSearchCard(
            modifier = Modifier.themeBackground()
        )
    }
}