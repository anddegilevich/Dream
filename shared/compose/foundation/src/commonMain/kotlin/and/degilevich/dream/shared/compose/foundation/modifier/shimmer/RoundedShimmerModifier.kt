package and.degilevich.dream.shared.compose.foundation.modifier.shimmer

import and.degilevich.dream.shared.compose.foundation.modifier.shimmer.color.ShimmerColors
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

fun Modifier.roundedShimmer(
    colors: ShimmerColors = ShimmerColors.Default
): Modifier {
    return this
        .clip(
            RoundedCornerShape(percent = 50)
        )
        .shimmer(colors = colors)
}