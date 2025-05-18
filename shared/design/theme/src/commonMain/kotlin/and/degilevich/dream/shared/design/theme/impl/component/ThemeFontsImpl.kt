package and.degilevich.dream.shared.design.theme.impl.component

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.theme.api.component.ThemeFonts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import dev.icerock.moko.resources.compose.asFont

@Immutable
internal class ThemeFontsImpl : ThemeFonts {
    override val avenir: FontFamily
        @Composable
        get() {
            val fonts = listOfNotNull(
                Res.fonts.avenirnextcyr_heavy.asFont(
                    weight = FontWeight.Black,
                ),
                Res.fonts.avenirnextcyr_heavyitalic.asFont(
                    weight = FontWeight.Black,
                    style = FontStyle.Italic
                ),
                Res.fonts.avenirnextcyr_bold.asFont(
                    weight = FontWeight.Bold
                ),
                Res.fonts.avenirnextcyr_bolditalic.asFont(
                    weight = FontWeight.Bold,
                    style = FontStyle.Italic
                ),
                Res.fonts.avenirnextcyr_medium.asFont(
                    weight = FontWeight.Medium,
                ),
                Res.fonts.avenirnextcyr_mediumitalic.asFont(
                    weight = FontWeight.Medium,
                    style = FontStyle.Italic
                ),
                Res.fonts.avenirnextcyr_regular.asFont(
                    weight = FontWeight.Normal
                ),
                Res.fonts.avenirnextcyr_italic.asFont(
                    weight = FontWeight.Normal,
                    style = FontStyle.Italic
                ),
                Res.fonts.avenirnextcyr_light.asFont(
                    weight = FontWeight.Light
                ),
                Res.fonts.avenirnextcyr_lightitalic.asFont(
                    weight = FontWeight.Light,
                    style = FontStyle.Italic
                ),
                Res.fonts.avenirnextcyr_thin.asFont(
                    weight = FontWeight.Thin
                ),
                Res.fonts.avenirnextcyr_thinitalic.asFont(
                    weight = FontWeight.Thin,
                    style = FontStyle.Italic
                ),
                Res.fonts.avenirnextcyr_ultralight.asFont(
                    weight = FontWeight.ExtraLight
                ),
                Res.fonts.avenirnextcyr_ultralightit.asFont(
                    weight = FontWeight.ExtraLight,
                    style = FontStyle.Italic
                ),

            )
            return FontFamily(fonts)
        }
}