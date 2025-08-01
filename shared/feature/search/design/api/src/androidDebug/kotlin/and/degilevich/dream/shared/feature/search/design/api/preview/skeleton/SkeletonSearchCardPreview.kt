package and.degilevich.dream.shared.feature.search.design.api.preview.skeleton

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.search.design.api.design.skeleton.SkeletonSearchCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun SkeletonSearchCardDarkPreview() {
    ComposeAppTheme(isDarkMode = true) {
        SkeletonSearchCard(
            modifier = Modifier.themeBackground()
        )
    }
}

@Preview
@Composable
private fun SkeletonSearchCardLightPreview() {
    ComposeAppTheme(isDarkMode = false) {
        SkeletonSearchCard(
            modifier = Modifier.themeBackground()
        )
    }
}