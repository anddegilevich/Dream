package and.degilevich.dream.shared.feature.playlist.ui.api.view

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun PlaylistIcon(
    iconUrl: String,
    modifier: Modifier = Modifier
) {
    val painter = rememberAsyncImagePainter(model = iconUrl)
    val asyncImageState by painter.state.collectAsState()
    val transition = updateTransition(asyncImageState)

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        transition.Crossfade(
            modifier = Modifier.matchParentSize(),
            contentKey = { imageState -> imageState::class }
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
                    PlaylistIconPlaceholder(
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

@LightDarkPreviews
@Composable
private fun PlaylistIconPreview() = ComposeAppTheme {
    PlaylistIcon(
        modifier = Modifier.size(152.dp),
        iconUrl = ""
    )
}
