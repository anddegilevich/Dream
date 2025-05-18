package and.degilevich.dream.shared.design.theme.impl.component

import and.degilevich.dream.shared.design.theme.api.component.ThemeFonts
import and.degilevich.dream.shared.design.theme.api.component.ThemeTypography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
class ThemeTypographyImpl(
    private val fonts: ThemeFonts
) : ThemeTypography {
    override val h1: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = fonts.avenir,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            lineHeight = 36.sp
        )
    override val h2: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = fonts.avenir,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            lineHeight = 36.sp
        )
    override val h3: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = fonts.avenir,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            lineHeight = 36.sp
        )
    override val main: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = fonts.avenir,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            lineHeight = 36.sp
        )
    override val label: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = fonts.avenir,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            lineHeight = 36.sp
        )
}