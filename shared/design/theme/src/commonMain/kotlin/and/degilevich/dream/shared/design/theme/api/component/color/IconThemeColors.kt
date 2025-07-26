package and.degilevich.dream.shared.design.theme.api.component.color

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

interface IconThemeColors {
    val primary: Color
        @Composable
        get
    val secondary: Color
        @Composable
        get
    val placeholderBackground: Color
        @Composable
        get
}