package and.degilevich.dream.shared.feature.user.ui.api.view

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.user.ui.api.model.UserAvatarUIData
import and.degilevich.dream.shared.feature.user.ui.api.preview.UserAvatarUIDataPreviewProvider
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.updateTransition
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
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun UserAvatar(
    data: UserAvatarUIData,
    size: Dp,
    modifier: Modifier = Modifier
) {
    val painter = rememberAsyncImagePainter(model = data.url)
    val asyncImageState by painter.state.collectAsState()
    val transition = updateTransition(asyncImageState)

    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape),
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
                    UserAvatarPlaceholder(
                        firstLetter = data.firstLetter,
                        size = size
                    )
                }
            }
        }
    }
}

@LightDarkPreviews
@Composable
private fun UserAvatarPreview(
    @PreviewParameter(UserAvatarUIDataPreviewProvider::class)
    data: UserAvatarUIData
) = ComposeAppTheme {
    UserAvatar(
        data = data,
        size = 40.dp
    )
}
