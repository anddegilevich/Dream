package and.degilevich.dream.shared.design.theme.api.component.color

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

interface CommonThemeColors {
    val background: Color
        @Composable
        get
    val brandGreen: Color
        @Composable
        get
    val ripple: Color
        @Composable
        get
    val icon: Color
        @Composable
        get
    val iconPlaceholderBackground: Color
        @Composable
        get
    val outline: Color
        @Composable
        get
}