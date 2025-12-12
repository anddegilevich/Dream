package and.degilevich.dream.shared.feature.artist.design.api.preview

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.artist.design.api.design.ArtistIconPlaceholder
import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@DayNightPreviews
@Composable
private fun ArtistIconPlaceholderPreview() {
    ComposeAppTheme {
        ArtistIconPlaceholder(
            modifier = Modifier.size(64.dp)
        )
    }
}