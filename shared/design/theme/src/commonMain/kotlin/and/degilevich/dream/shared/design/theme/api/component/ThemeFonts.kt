package and.degilevich.dream.shared.design.theme.api.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.font.FontFamily

@Immutable
interface ThemeFonts {
    val avenir: FontFamily
        @Composable
        get
}