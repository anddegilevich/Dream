package and.degilevich.dream.shared.design.theme.api.component.color

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
interface ThemeIndifferentColors {
    val brandGreen: Color
        @Composable
        get
}