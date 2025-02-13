package and.degilevich.dream.shared.foundation.compose.modifier.shimmer

import and.degilevich.dream.shared.foundation.compose.modifier.shimmer.color.ShimmerColors
import and.degilevich.dream.shared.foundation.compose.modifier.shimmer.controller.rememberShimmerGradient
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import kotlin.math.max

@Suppress("SpreadOperator")
fun Modifier.shimmer(
    colors: ShimmerColors = ShimmerColors.Default
): Modifier {
    return composed {
        var viewSize by remember { mutableStateOf(IntSize.Zero) }
        val offset = remember(viewSize) {
            val maxDimension = max(viewSize.height, viewSize.width) * 2f
            Offset(
                x = maxDimension,
                y = maxDimension
            )
        }
        val gradient = rememberShimmerGradient(colors = colors)

        onGloballyPositioned { layoutCoordinates ->
            viewSize = layoutCoordinates.size
        }.drawWithContent {
            drawRect(
                brush = Brush.linearGradient(
                    *gradient,
                    start = Offset.Zero,
                    end = offset,
                )
            )
        }
    }
}