package and.degilevich.dream.shared.feature.artist.design.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.artist.design.api.design.ArtistIcon
import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@DayNightPreviews
@Composable
private fun ArtistIconPreview() {
    ComposeAppTheme {
        ArtistIcon(
            modifier = Modifier.size(100.dp),
            iconUrl = ""
        )
    }
}