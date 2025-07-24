package and.degilevich.dream.shared.design.system.loading

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
private fun LoadingIndicatorDarkPreview() {
    ComposeAppTheme(isDarkMode = true) {
        LoadingIndicator(
            modifier = Modifier.size(40.dp)
        )
    }
}

@Preview
@Composable
private fun LoadingIndicatorLightPreview() {
    ComposeAppTheme(isDarkMode = false) {
        LoadingIndicator(
            modifier = Modifier.size(40.dp)
        )
    }
}