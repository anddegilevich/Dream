package and.degilevich.dream.shared.feature.artist.design.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.artist.design.api.design.ArtistIcon
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@PreviewLightDark
@Composable
private fun ArtistIconPreview() {
    ComposeAppTheme {
        ArtistIcon(
            modifier = Modifier.size(100.dp),
            iconUrl = ""
        )
    }
}