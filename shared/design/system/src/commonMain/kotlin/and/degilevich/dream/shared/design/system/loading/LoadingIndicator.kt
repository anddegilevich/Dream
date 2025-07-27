package and.degilevich.dream.shared.design.system.loading

import and.degilevich.dream.shared.design.theme.api.Theme
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap

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