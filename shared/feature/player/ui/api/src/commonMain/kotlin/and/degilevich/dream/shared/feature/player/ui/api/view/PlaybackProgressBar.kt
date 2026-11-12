package and.degilevich.dream.shared.feature.player.ui.api.view

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.player.ui.api.model.PlaybackProgressUIData
import and.degilevich.dream.shared.feature.player.ui.api.preview.PlaybackProgressUIDataPreviewProvider
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun PlaybackProgressBar(
    fraction: Float,
    height: Dp,
    modifier: Modifier = Modifier
) {
    val animatedFraction by animateFloatAsState(
        targetValue = fraction,
        animationSpec = tween(
            easing = LinearEasing
        )
    )

    LinearProgressIndicator(
        modifier = modifier.height(height),
        progress = animatedFraction,
        color = Theme.colors.common.brand,
        backgroundColor = Theme.colors.common.line
    )
}

@PreviewLightDark
@Composable
private fun PlaybackProgressBarPreview(
    @PreviewParameter(PlaybackProgressUIDataPreviewProvider::class)
    data: PlaybackProgressUIData
) = ComposeAppTheme {
    PlaybackProgressBar(
        modifier = Modifier
            .themeBackground()
            .fillMaxWidth(),
        height = 4.dp,
        fraction = data.fraction
    )
}
