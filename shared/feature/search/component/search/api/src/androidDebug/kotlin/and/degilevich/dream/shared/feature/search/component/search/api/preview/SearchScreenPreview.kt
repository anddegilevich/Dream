package and.degilevich.dream.shared.feature.search.component.search.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.search.component.search.api.design.SearchScreen
import and.degilevich.dream.shared.feature.search.component.search.api.preview.provider.SearchUIStatePreviewProvider
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun SearchScreenDarkPreview() {
    ComposeAppTheme(isDarkMode = true) {
        SearchScreen(
            state = SearchUIStatePreviewProvider.provide()
        ) { }
    }
}

@Preview
@Composable
private fun SearchScreenLightPreview() {
    ComposeAppTheme(isDarkMode = false) {
        SearchScreen(
            state = SearchUIStatePreviewProvider.provide()
        ) { }
    }
}

@Preview
@Composable
private fun SkeletonSearchScreenDarkPreview() {
    ComposeAppTheme(isDarkMode = true) {
        SearchScreen(
            state = SearchUIStatePreviewProvider.provideSkeleton()
        ) { }
    }
}

@Preview
@Composable
private fun SkeletonSearchScreenLightPreview() {
    ComposeAppTheme(isDarkMode = false) {
        SearchScreen(
            state = SearchUIStatePreviewProvider.provideSkeleton()
        ) { }
    }
}