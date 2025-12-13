package and.degilevich.dream.shared.feature.search.design.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.search.design.api.design.SearchTextField
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.runtime.Composable

@PreviewLightDark
@Composable
private fun SearchTextFieldPreview() {
    ComposeAppTheme {
        SearchTextField(
            value = "Search",
        ) { }
    }
}