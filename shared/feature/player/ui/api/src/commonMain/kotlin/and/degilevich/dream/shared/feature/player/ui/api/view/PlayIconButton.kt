package and.degilevich.dream.shared.feature.player.ui.api.view

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.button.IconButton
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.foundation.compose.preview.BooleanPreviewProvider
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun PlayIconButton(
    isPlaying: Boolean,
    modifier: Modifier = Modifier,
    onClicked: () -> Unit
) {
    IconButton(
        modifier = modifier,
        painter = painterResource(
            if (isPlaying) {
                Res.images.ic_pause
            } else {
                Res.images.ic_play
            }
        ),
        onClicked = onClicked
    )
}

@LightDarkPreviews
@Composable
private fun PlayIconButtonPreview(
    @PreviewParameter(BooleanPreviewProvider::class)
    isPlaying: Boolean
) = ComposeAppTheme {
    PlayIconButton(
        modifier = Modifier
            .themeBackground()
            .size(24.dp),
        isPlaying = isPlaying
    ) {}
}
