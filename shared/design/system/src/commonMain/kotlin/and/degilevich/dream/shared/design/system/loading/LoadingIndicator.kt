package and.degilevich.dream.shared.design.system.loading

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LoadingIndicator(
    modifier: Modifier = Modifier,
    size: Dp = DEFAULT_SIZE,
    color: Color = Theme.colors.common.brand
) {
    CircularProgressIndicator(
        modifier = modifier.size(size),
        color = color,
        strokeWidth = size * STROKE_WIDTH_RATIO,
        strokeCap = StrokeCap.Round
    )
}

private val DEFAULT_SIZE = 40.dp

private const val STROKE_WIDTH_RATIO = 0.1f

@LightDarkPreviews
@Composable
private fun LoadingIndicatorPreview() = ComposeAppTheme {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        LoadingIndicator(size = 12.dp)
        LoadingIndicator(size = 24.dp)
        LoadingIndicator()
        LoadingIndicator(size = 64.dp)
    }
}
