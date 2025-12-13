package and.degilevich.dream.shared.feature.artist.design.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.artist.design.api.design.ArtistIconPlaceholder
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@PreviewLightDark
@Composable
private fun ArtistIconPlaceholderPreview() {
    ComposeAppTheme {
        ArtistIconPlaceholder(
            modifier = Modifier.size(64.dp)
        )
    }
}