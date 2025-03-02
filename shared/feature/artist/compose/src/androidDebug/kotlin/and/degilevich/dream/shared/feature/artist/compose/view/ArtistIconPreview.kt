package and.degilevich.dream.shared.feature.artist.compose.view

import and.degilevich.dream.shared.compose.theme.api.DreamTheme
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ArtistIconPreview() {
    DreamTheme {
        ArtistIcon(
            modifier = Modifier.size(100.dp),
            iconUrl = ""
        )
    }
}