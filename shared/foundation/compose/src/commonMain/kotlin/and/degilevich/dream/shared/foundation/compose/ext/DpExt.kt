package and.degilevich.dream.shared.foundation.compose.ext

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp

fun Dp.toPx(density: Density): Float {
    return with(density) { this@toPx.toPx() }
}

@Composable
fun Dp.toPx(): Float {
    val density = LocalDensity.current
    return remember(this, density) { this.toPx(density) }
}