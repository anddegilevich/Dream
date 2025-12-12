package and.degilevich.dream.shared.design.system.loading

import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@DayNightPreviews
@Composable
private fun LoadingIndicatorPreview() {
    LoadingIndicator(
        modifier = Modifier.size(40.dp)
    )
}