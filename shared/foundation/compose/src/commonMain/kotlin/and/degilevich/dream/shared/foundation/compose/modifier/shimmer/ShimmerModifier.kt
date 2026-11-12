package and.degilevich.dream.shared.foundation.compose.modifier.shimmer

import and.degilevich.dream.shared.foundation.compose.modifier.shimmer.color.ShimmerColors
import and.degilevich.dream.shared.foundation.compose.modifier.shimmer.controller.ShimmerGradientAnimationController
import and.degilevich.dream.shared.foundation.compose.modifier.shimmer.controller.ShimmerGradientAnimationControllerImpl
import androidx.compose.animation.core.Animatable
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
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.node.DrawModifierNode
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.node.invalidateDraw
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.max

fun Modifier.shimmer(
    colors: ShimmerColors = ShimmerColors.Default
): Modifier {
    return this then ShimmerModifierNodeElement(colors = colors)
}

@Suppress("ModifierNodeInspectableProperties")
private data class ShimmerModifierNodeElement(
    private val colors: ShimmerColors
) : ModifierNodeElement<ShimmerNode>() {

    override fun create(): ShimmerNode {
        return ShimmerNode(colors = colors)
    }

    override fun update(node: ShimmerNode) {
        node.update(colors = colors)
    }
}

private class ShimmerNode(
    private var colors: ShimmerColors
) : Modifier.Node(), DrawModifierNode {

    private val animatableShimmerStart = Animatable(initialValue = 0f)
    private val animatableFlash = Animatable(initialValue = 0f)
    private val animatableShimmerEnd = Animatable(initialValue = 0f)
    private var animationController: ShimmerGradientAnimationController? = null

    override fun onAttach() {
        animationController = ShimmerGradientAnimationControllerImpl(
            coroutineScope = coroutineScope,
            animatableShimmerStart = animatableShimmerStart,
            animatableFlash = animatableFlash,
            animatableShimmerEnd = animatableShimmerEnd
        ).apply { start() }
    }

    override fun onDetach() {
        animationController?.stop()
        animationController = null
    }

    fun update(colors: ShimmerColors) {
        if (this.colors == colors) return
        this.colors = colors
        invalidateDraw()
    }

    @Suppress("SpreadOperator")
    override fun ContentDrawScope.draw() {
        val maxDimension = max(size.height, size.width) * 2f
        drawRect(
            brush = Brush.linearGradient(
                *arrayOf(
                    animatableShimmerStart.value to colors.background,
                    animatableFlash.value to colors.flash,
                    animatableShimmerEnd.value to colors.background
                ),
                start = Offset.Zero,
                end = Offset(
                    x = maxDimension,
                    y = maxDimension
                ),
            )
        )
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