package and.degilevich.dream.shared.design.theme.api.component.color.field

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

interface SearchFieldThemeColors {
    val text: Color
        @Composable
        get
    val placeholder: Color
        @Composable
        get
    val cursor: Color
        @Composable
        get
    val icon: Color
        @Composable
        get
    val background: Color
        @Composable
        get
}