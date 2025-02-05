package and.degilevich.dream.shared.foundation.compose.modifier.skeleton

import and.degilevich.dream.shared.foundation.compose.modifier.shimmer.color.ShimmerColors
import and.degilevich.dream.shared.foundation.compose.modifier.shimmer.roundedShimmer
import androidx.compose.ui.Modifier

fun Modifier.skeleton(
    isSkeleton: Boolean,
    colors: ShimmerColors = ShimmerColors.Default
): Modifier {
    return if (isSkeleton) {
        roundedShimmer(colors = colors)
    } else {
        this
    }
}