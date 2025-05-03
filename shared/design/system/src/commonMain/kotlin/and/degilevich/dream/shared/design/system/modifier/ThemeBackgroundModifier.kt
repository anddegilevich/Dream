package and.degilevich.dream.shared.design.system.modifier

import and.degilevich.dream.shared.design.theme.api.Theme
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

fun Modifier.themeBackground(): Modifier {
    return this.composed {
        background(Theme.colors.background)
    }
}