package and.degilevich.dream.shared.feature.player.ui.api.view

import and.degilevich.dream.Res
import and.degilevich.dream.ic_shuffle
import and.degilevich.dream.shared.design.system.button.IconButton
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.foundation.compose.preview.BooleanPreviewProvider
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun ShuffleIconButton(
    isShuffling: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val tint by animateColorAsState(
        targetValue = if (isShuffling) {
            Theme.colors.common.brand
        } else {
            Theme.colors.icon.secondary
        }
    )

    IconButton(
        modifier = modifier,
        painter = painterResource(Res.images.ic_shuffle),
        tint = tint,
        onClick = onClick
    )
}

@PreviewLightDark
@Composable
private fun ShuffleIconButtonPreview(
    @PreviewParameter(BooleanPreviewProvider::class)
    isShuffling: Boolean
) = ComposeAppTheme {
    ShuffleIconButton(
        modifier = Modifier
            .themeBackground()
            .size(24.dp),
        isShuffling = isShuffling,
        onClick = {}
    )
}
