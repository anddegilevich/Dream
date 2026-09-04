package and.degilevich.dream.shated.feature.track.ui.api.view

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import and.degilevich.dream.shated.feature.track.ui.api.model.TrackCardInfoUIData
import and.degilevich.dream.shated.feature.track.ui.api.preview.TrackCardInfoUIDataPreviewProvider
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp

@Composable
fun TrackCardInfoView(
    data: TrackCardInfoUIData,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(space = 4.dp)
    ) {
        Text(
            text = data.name,
            style = Theme.typography.main,
            color = Theme.colors.text.primary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = data.artists,
            style = Theme.typography.label,
            color = Theme.colors.text.secondary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@LightDarkPreviews
@Composable
private fun TrackCardInfoViewPreview(
    @PreviewParameter(TrackCardInfoUIDataPreviewProvider::class)
    data: TrackCardInfoUIData
) = ComposeAppTheme {
    TrackCardInfoView(
        modifier = Modifier.themeBackground(),
        data = data
    )
}
