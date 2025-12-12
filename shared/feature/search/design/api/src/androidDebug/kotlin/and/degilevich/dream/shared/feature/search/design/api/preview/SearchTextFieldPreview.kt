package and.degilevich.dream.shared.feature.search.design.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.search.design.api.design.SearchTextField
import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import androidx.compose.runtime.Composable

@DayNightPreviews
@Composable
private fun SearchTextFieldPreview() {
    ComposeAppTheme {
        SearchTextField(
            value = "Search",
        ) { }
    }
}