package and.degilevich.dream.shared.feature.player.ui.api.view

import and.degilevich.dream.Res
import and.degilevich.dream.ic_pause
import and.degilevich.dream.ic_play
import and.degilevich.dream.shared.design.system.button.IconButton
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.foundation.compose.preview.BooleanPreviewProvider
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun PlayIconButton(
    isPlaying: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
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
        onClick = onClick
    )
}

@PreviewLightDark
@Composable
private fun PlayIconButtonPreview(
    @PreviewParameter(BooleanPreviewProvider::class)
    isPlaying: Boolean
) = ComposeAppTheme {
    PlayIconButton(
        modifier = Modifier
            .themeBackground()
            .size(24.dp),
        isPlaying = isPlaying,
        onClick = {}
    )
}
