package and.degilevich.dream.shared.feature.search.component.search.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchUIState
import and.degilevich.dream.shared.feature.search.component.search.api.design.SearchScreen
import and.degilevich.dream.shared.feature.search.component.search.api.preview.provider.SearchUIStatePreviewProvider
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewParameter

@PreviewLightDark
@Composable
private fun SearchScreenPreview(
    @PreviewParameter(SearchUIStatePreviewProvider::class)
    state: SearchUIState
) {
    ComposeAppTheme {
        SearchScreen(
            state = state
        ) { }
    }
}