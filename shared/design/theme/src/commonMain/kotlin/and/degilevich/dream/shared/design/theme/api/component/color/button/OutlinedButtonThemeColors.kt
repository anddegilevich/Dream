package and.degilevich.dream.shared.design.theme.api.component.color.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

interface OutlinedButtonThemeColors {
    val outline: Color
        @Composable
        get
    val outlineDisabled: Color
        @Composable
        get
    val text: Color
        @Composable
        get
    val textDisabled: Color
        @Composable
        get
}