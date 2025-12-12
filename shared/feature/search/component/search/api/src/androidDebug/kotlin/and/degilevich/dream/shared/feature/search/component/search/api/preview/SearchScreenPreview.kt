package and.degilevich.dream.shared.feature.search.component.search.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.search.component.search.api.design.SearchScreen
import and.degilevich.dream.shared.feature.search.component.search.api.preview.provider.SearchUIStatePreviewProvider
import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import androidx.compose.runtime.Composable

@DayNightPreviews
@Composable
private fun SearchScreenPreview() {
    ComposeAppTheme {
        SearchScreen(
            state = SearchUIStatePreviewProvider.provide()
        ) { }
    }
}

@DayNightPreviews
@Composable
private fun SkeletonSearchScreenPreview() {
    ComposeAppTheme {
        SearchScreen(
            state = SearchUIStatePreviewProvider.provideSkeleton()
        ) { }
    }
}