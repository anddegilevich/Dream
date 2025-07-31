package and.degilevich.dream.shared.feature.search.design.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.search.design.api.design.SearchTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun SearchTextFieldDarkPreview() {
    ComposeAppTheme(isDarkMode = true) {
        SearchTextField(
            value = "Search",
        ) {}
    }
}

@Preview
@Composable
private fun SearchTextFieldLightPreview() {
    ComposeAppTheme(isDarkMode = false) {
        SearchTextField(
            value = "Search",
        ) {}
    }
}