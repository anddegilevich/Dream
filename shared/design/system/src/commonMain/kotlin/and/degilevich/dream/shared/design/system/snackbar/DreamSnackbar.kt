package and.degilevich.dream.shared.design.system.snackbar

import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.clickableWithDebounce
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.SnackbarData
import androidx.compose.material.Text
import androidx.compose.material.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun DreamSnackbar(
    data: SnackbarData,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 2.dp,
                color = Theme.colors.outline
            )
            .background(Theme.colors.background)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = data.message,
            color = Theme.colors.textPrimary,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Space(width = 12.dp)
        data.actionLabel?.let { action ->
            Text(
                modifier = Modifier.clickableWithDebounce(
                    indication = ripple(color = Theme.colors.ripple)
                ) {
                    data.performAction()
                },
                text = action,
                textDecoration = TextDecoration.Underline,
                color = Theme.colors.buttonBorderlessText
            )
        }
    }
}