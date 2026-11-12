package and.degilevich.dream.shared.feature.player.ui.api.view

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.player.ui.api.model.PlaybackProgressUIData
import and.degilevich.dream.shared.feature.player.ui.api.preview.PlaybackProgressUIDataPreviewProvider
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp

@Composable
fun PlaybackProgressView(
    data: PlaybackProgressUIData,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(space = 8.dp)
    ) {
        PlaybackProgressBar(
            modifier = Modifier
                .fillMaxWidth()
                .clip(CircleShape),
            fraction = data.fraction,
            height = 4.dp
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
