package and.degilevich.dream.shated.feature.track.ui.api.view

import and.degilevich.dream.shared.design.system.indication.themeRipple
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import and.degilevich.dream.shared.foundation.compose.click.rememberDebounced
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import and.degilevich.dream.shated.feature.track.ui.api.model.TrackCardUIData
import and.degilevich.dream.shated.feature.track.ui.api.preview.TrackCardUIDataPreviewProvider
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp

@Composable
fun TrackCard(
    data: TrackCardUIData,
    modifier: Modifier = Modifier,
    onClicked: (id: Identifier) -> Unit
) {
    val onClickedDebounced = rememberDebounced { onClicked(data.id) }

    Row(
        modifier = modifier
            .clickable(
                interactionSource = null,
                indication = themeRipple(),
                onClick = onClickedDebounced
            ),
        horizontalArrangement = Arrangement.spacedBy(space = 8.dp),
        verticalAlignment = Alignment.Top
    ) {
        TrackCardNumberView(number = data.number)
        TrackCardInfoView(data = data.info)
    }
}

@LightDarkPreviews
@Composable
private fun TrackCardPreview(
    @PreviewParameter(TrackCardUIDataPreviewProvider::class)
    data: TrackCardUIData
) = ComposeAppTheme {
    TrackCard(
        modifier = Modifier.themeBackground(),
        data = data
    ) { }
}
