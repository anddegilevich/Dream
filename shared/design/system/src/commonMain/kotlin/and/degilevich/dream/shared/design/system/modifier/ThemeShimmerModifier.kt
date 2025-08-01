package and.degilevich.dream.shared.design.system.modifier

import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.foundation.compose.modifier.shimmer.color.ShimmerColors
import and.degilevich.dream.shared.foundation.compose.modifier.shimmer.shimmer
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

fun Modifier.themeShimmer(): Modifier {
    return this.composed {
        shimmer(
            colors = object : ShimmerColors {
                override val flash: Color = Theme.colors.shimmer.flash
                override val background: Color = Theme.colors.shimmer.background
            }
        )
    }
}

fun Modifier.roundedThemeShimmer(): Modifier {
    return this.composed {
        clip(
            shape = RoundedCornerShape(percent = 50)
        ).themeShimmer()
    }
}