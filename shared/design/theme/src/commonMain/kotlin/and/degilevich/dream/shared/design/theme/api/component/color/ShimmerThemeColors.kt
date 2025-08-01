package and.degilevich.dream.shared.design.theme.api.component.color

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

interface ShimmerThemeColors {
    val flash: Color
        @Composable
        get
    val background: Color
        @Composable
        get
}