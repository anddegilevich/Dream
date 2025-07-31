package and.degilevich.dream.shared.design.system.indication

import and.degilevich.dream.shared.design.theme.api.Theme
import androidx.compose.foundation.Indication
import androidx.compose.material.ripple
import androidx.compose.runtime.Composable

@Composable
fun themeRipple(): Indication {
    return ripple(color = Theme.colors.common.ripple)
}