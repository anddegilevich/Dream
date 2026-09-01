package and.degilevich.dream.shated.feature.track.ui.api.view

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TrackCardNumberView(
    number: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier.widthIn(min = 28.dp),
        text = number,
        style = Theme.typography.main,
        color = Theme.colors.text.primary,
        textAlign = TextAlign.End
    )
}

@LightDarkPreviews
@Composable
private fun TrackCardNumberViewPreview() = ComposeAppTheme {
    TrackCardNumberView(
        modifier = Modifier.themeBackground(),
        number = "1"
    )
}
