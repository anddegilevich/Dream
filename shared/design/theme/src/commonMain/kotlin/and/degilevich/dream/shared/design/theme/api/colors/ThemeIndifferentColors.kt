package and.degilevich.dream.shared.design.theme.api.colors

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

interface ThemeIndifferentColors {
    val brandGreen: Color
        @Composable
        get
    val white: Color
        @Composable
        get
    val black: Color
        @Composable
        get
}