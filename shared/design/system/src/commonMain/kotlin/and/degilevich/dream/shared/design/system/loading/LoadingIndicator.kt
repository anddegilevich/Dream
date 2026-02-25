package and.degilevich.dream.shared.design.system.loading

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.ui.unit.dp

@Composable
fun LoadingIndicator(
    modifier: Modifier = Modifier
) {
    CircularProgressIndicator(
        modifier = modifier,
        color = Theme.colors.common.brand,
        strokeCap = StrokeCap.Round
    )
}

@LightDarkPreviews
@Composable
private fun LoadingIndicatorPreview() = ComposeAppTheme {
    LoadingIndicator(
        modifier = Modifier.size(40.dp)
    )
}