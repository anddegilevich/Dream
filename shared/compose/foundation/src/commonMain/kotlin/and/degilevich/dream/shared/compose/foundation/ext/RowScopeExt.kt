package and.degilevich.dream.shared.compose.foundation.ext

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun RowScope.Space(
    width: Dp,
    modifier: Modifier = Modifier,
) {
    Spacer(modifier = modifier.width(width))
}