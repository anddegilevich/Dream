package and.degilevich.dream.shared.design.theme.api.component.color.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

interface BorderlessButtonThemeColors {
    val text: Color
        @Composable
        get
    val textDisabled: Color
        @Composable
        get
}