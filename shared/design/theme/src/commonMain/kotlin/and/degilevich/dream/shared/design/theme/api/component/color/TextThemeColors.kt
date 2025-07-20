package and.degilevich.dream.shared.design.theme.api.component.color

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

interface TextThemeColors {
    val primary: Color
        @Composable
        get
    val secondary: Color
        @Composable
        get
    val label: Color
        @Composable
        get
}