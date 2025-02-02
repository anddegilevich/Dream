package and.degilevich.dream.shared.compose.theme.api

import and.degilevich.dream.shared.compose.theme.api.colors.DreamColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

object Theme {

    val colors: DreamColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current
}