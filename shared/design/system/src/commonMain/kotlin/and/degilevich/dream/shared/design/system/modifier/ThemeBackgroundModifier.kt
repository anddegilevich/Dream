package and.degilevich.dream.shared.design.system.modifier

import and.degilevich.dream.shared.design.theme.api.Theme
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape

fun Modifier.themeBackground(shape: Shape = RectangleShape): Modifier {
    return this.composed {
        background(
            color = Theme.colors.common.background,
            shape = shape
        )
    }
}