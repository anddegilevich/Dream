package and.degilevich.dream.shared.design.theme.api

import and.degilevich.dream.shared.design.theme.api.colors.DreamColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

object Theme {
    val colors: DreamColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current
}