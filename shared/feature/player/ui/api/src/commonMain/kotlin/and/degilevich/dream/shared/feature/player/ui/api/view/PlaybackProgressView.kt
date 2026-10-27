package and.degilevich.dream.shared.feature.player.ui.api.view

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.player.ui.api.model.PlaybackProgressUIData
import and.degilevich.dream.shared.feature.player.ui.api.preview.PlaybackProgressUIDataPreviewProvider
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp

@Composable
fun PlaybackProgressView(
    data: PlaybackProgressUIData,
    modifier: Modifier = Modifier
) {
    val fraction by animateFloatAsState(
        targetValue = data.fraction,
        animationSpec = tween(
            easing = LinearEasing
        )
    )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(space = 8.dp)
    ) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .clip(CircleShape),
            progress = fraction,
            color = Theme.colors.common.brand,
            backgroundColor = Theme.colors.common.line
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = data.elapsed,
                style = Theme.typography.label,
                color = Theme.colors.text.secondary
            )
            Text(
                text = data.remaining,
                style = Theme.typography.label,
                color = Theme.colors.text.secondary
            )
        }
    }
}

@LightDarkPreviews
@Composable
private fun PlaybackProgressViewPreview(
    @PreviewParameter(PlaybackProgressUIDataPreviewProvider::class)
    data: PlaybackProgressUIData
) = ComposeAppTheme {
    PlaybackProgressView(
        modifier = Modifier.themeBackground(),
        data = data
    )
}
