package and.degilevich.dream.shared.design.theme.api.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle

@Immutable
interface ThemeTypography {
    val h1: TextStyle
        @Composable
        get
    val h2: TextStyle
        @Composable
        get
    val h3: TextStyle
        @Composable
        get
    val h4: TextStyle
        @Composable
        get
    val main: TextStyle
        @Composable
        get
    val label: TextStyle
        @Composable
        get
}