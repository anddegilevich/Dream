package and.degilevich.dream.shared.foundation.compose.modifier.shimmer

import and.degilevich.dream.shared.foundation.compose.modifier.shimmer.color.ShimmerColors
import and.degilevich.dream.shared.foundation.compose.modifier.shimmer.controller.rememberShimmerGradient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
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

@Preview
@Composable
private fun ShimmerModifierPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .shimmer()
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Spacer(
                    modifier = Modifier
                        .width(300.dp)
                        .height(60.dp)
                        .shimmer()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .shimmer()
                )
            }
        }

        for (i in 0..4) {
            key(i) {
                Spacer(modifier = Modifier.height(16.dp))
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(32.dp)
                        .shimmer()
                )
            }
        }
    }
}