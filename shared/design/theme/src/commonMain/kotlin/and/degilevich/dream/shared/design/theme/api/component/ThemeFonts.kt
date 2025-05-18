package and.degilevich.dream.shared.design.theme.api.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.font.FontFamily

@Immutable
interface ThemeFonts {
    val avenir: FontFamily
        @Composable
        get

    class Empty : ThemeFonts {
        override val avenir: FontFamily
            @Composable
            get() = FontFamily.Default
    }
}