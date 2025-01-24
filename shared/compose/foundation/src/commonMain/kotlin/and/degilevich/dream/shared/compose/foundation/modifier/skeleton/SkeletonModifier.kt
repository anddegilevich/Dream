package and.degilevich.dream.shared.compose.foundation.modifier.skeleton

import and.degilevich.dream.shared.compose.foundation.modifier.shimmer.ShimmerColors
import and.degilevich.dream.shared.compose.foundation.modifier.shimmer.roundedShimmer
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