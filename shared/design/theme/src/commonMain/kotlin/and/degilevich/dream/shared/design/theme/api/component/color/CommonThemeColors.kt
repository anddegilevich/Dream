package and.degilevich.dream.shared.design.theme.api.component.color

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

interface CommonThemeColors {
    val background: Color
        @Composable
        get
    val brand: Color
        @Composable
        get
    val ripple: Color
        @Composable
        get
    val line: Color
        @Composable
        get
}