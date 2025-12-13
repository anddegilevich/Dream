package and.degilevich.dream.shared.feature.search.component.search.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.search.component.search.api.design.SearchScreen
import and.degilevich.dream.shared.feature.search.component.search.api.preview.provider.SearchUIStatePreviewProvider
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable

@PreviewLightDark
@Composable
private fun SearchScreenPreview() {
    ComposeAppTheme {
        SearchScreen(
            state = SearchUIStatePreviewProvider.provide()
        ) { }
    }
}

@PreviewLightDark
@Composable
private fun SkeletonSearchScreenPreview() {
    ComposeAppTheme {
        SearchScreen(
            state = SearchUIStatePreviewProvider.provideSkeleton()
        ) { }
    }
}