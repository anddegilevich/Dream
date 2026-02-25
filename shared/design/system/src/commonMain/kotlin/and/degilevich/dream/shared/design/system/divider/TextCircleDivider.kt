package and.degilevich.dream.shared.design.system.divider

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.ui.unit.dp

@Composable
fun TextCircleDivider(
    color: Color,
    modifier: Modifier = Modifier
) {
    Spacer(
        modifier = modifier
            .size(4.dp)
            .background(
                shape = CircleShape,
                color = color
            )
    )
}

@LightDarkPreviews
@Composable
private fun TextCircleDividerPreview() = ComposeAppTheme {
    TextCircleDivider(
        color = Theme.colors.text.secondary
    )
}