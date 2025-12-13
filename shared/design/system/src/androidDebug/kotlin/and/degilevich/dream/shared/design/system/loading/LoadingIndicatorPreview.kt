package and.degilevich.dream.shared.design.system.loading

import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@PreviewLightDark
@Composable
private fun LoadingIndicatorPreview() {
    LoadingIndicator(
        modifier = Modifier.size(40.dp)
    )
}