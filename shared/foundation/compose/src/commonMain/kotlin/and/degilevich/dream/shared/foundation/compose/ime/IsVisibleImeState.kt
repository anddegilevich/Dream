package and.degilevich.dream.shared.foundation.compose.ime

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.ime
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalDensity

@Composable
fun rememberIsVisibleIme(): State<Boolean> {
    val density = LocalDensity.current
    val imeInsets = WindowInsets.ime
    val isVisibleIme = rememberUpdatedState(
        newValue = imeInsets.getBottom(density) > 0
    )
    return isVisibleIme
}