package and.degilevich.dream.shared.feature.artist.design.api.design

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter

@Composable
fun ArtistIcon(
    iconUrl: String,
    modifier: Modifier = Modifier
) {
    val painter = rememberAsyncImagePainter(model = iconUrl)
    val asyncImageState by painter.state.collectAsState()

    Box(
        modifier = modifier
            .clip(CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Crossfade(
            modifier = Modifier.matchParentSize(),
            targetState = asyncImageState
        ) { imageState ->
            when (imageState) {
                is AsyncImagePainter.State.Success -> {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painter,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }

                else -> {
                    ArtistIconPlaceholder(
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

@LightDarkPreviews
@Composable
private fun ArtistIconPreview() = ComposeAppTheme {
    ArtistIcon(
        modifier = Modifier.size(100.dp),
        iconUrl = ""
    )
}