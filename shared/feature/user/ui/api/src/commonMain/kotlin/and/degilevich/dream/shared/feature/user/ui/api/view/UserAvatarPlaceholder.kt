package and.degilevich.dream.shared.feature.user.ui.api.view

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun UserAvatarPlaceholder(
    firstLetter: String,
    size: Dp,
    modifier: Modifier = Modifier
) {
    val letterSize = with(LocalDensity.current) { (size * LETTER_FRACTION).toSp() }

    Box(
        modifier = modifier
            .size(size)
            .background(color = Theme.colors.common.brand),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = firstLetter,
            color = Theme.colors.text.primary,
            style = Theme.typography.h4.copy(
                fontSize = letterSize,
                lineHeight = letterSize
            )
        )
    }
}

@LightDarkPreviews
@Composable
private fun UserAvatarPlaceholderPreview() = ComposeAppTheme {
    UserAvatarPlaceholder(
        firstLetter = "U",
        size = 40.dp
    )
}

private const val LETTER_FRACTION = 0.5f
