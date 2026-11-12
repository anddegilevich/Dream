package and.degilevich.dream.shared.foundation.compose.modifier.clickable

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.node.LayoutModifierNode
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

fun Modifier.scaleOnClick(
    interactionSource: MutableInteractionSource,
    scale: Float = DEFAULT_SCALE_VALUE,
    isEnabled: Boolean = true,
): Modifier {
    return this then ScaleOnClickModifierNodeElement(
        interactionSource = interactionSource,
        scale = scale,
        isEnabled = isEnabled
    )
}

@Suppress("ModifierNodeInspectableProperties")
private data class ScaleOnClickModifierNodeElement(
    private val interactionSource: InteractionSource,
    private val scale: Float,
    private val isEnabled: Boolean
) : ModifierNodeElement<ScaleOnClickNode>() {

    override fun create(): ScaleOnClickNode {
        return ScaleOnClickNode(
            interactionSource = interactionSource,
            scale = scale,
            isEnabled = isEnabled
        )
    }

    override fun update(node: ScaleOnClickNode) {
        node.update(
            interactionSource = interactionSource,
            scale = scale,
            isEnabled = isEnabled
        )
    }
}

private class ScaleOnClickNode(
    private var interactionSource: InteractionSource,
    private var scale: Float,
    private var isEnabled: Boolean
) : Modifier.Node(), LayoutModifierNode {

    private val animatableScale = Animatable(initialValue = 1f)
    private var isPressed = false
    private var interactionsJob: Job? = null

    override fun onAttach() {
        collectInteractions()
    }

    override fun onDetach() {
        interactionsJob = null
        isPressed = false
    }

    fun update(
        interactionSource: InteractionSource,
        scale: Float,
        isEnabled: Boolean
    ) {
        this.scale = scale
        this.isEnabled = isEnabled
        if (this.interactionSource != interactionSource) {
            this.interactionSource = interactionSource
            isPressed = false
            collectInteractions()
        }
        animateToTarget()
    }

    override fun MeasureScope.measure(
        measurable: Measurable,
        constraints: Constraints
    ): MeasureResult {
        val placeable = measurable.measure(constraints)
        return layout(
            width = placeable.width,
            height = placeable.height
        ) {
            placeable.placeWithLayer(
                x = 0,
                y = 0
            ) {
                scaleX = animatableScale.value
                scaleY = animatableScale.value
            }
        }
    }

    private fun collectInteractions() {
        if (!isAttached) return
        interactionsJob?.cancel()
        interactionsJob = coroutineScope.launch {
            interactionSource.interactions.collectLatest { interaction ->
                isPressed = when (interaction) {
                    is PressInteraction.Press -> {
                        true
                    }

                    else -> {
                        delay(PRESS_RELEASE_DELAY)
                        false
                    }
                }
                animateToTarget()
            }
        }
    }

    private fun animateToTarget() {
        if (!isAttached) return
        coroutineScope.launch {
            animatableScale.animateTo(
                targetValue = if (isPressed && isEnabled) scale else 1f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        }
    }
}

@Preview
@Composable
private fun ScaleOnClickModifierPreview() {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Spacer(
            modifier = Modifier
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) { }
                .scaleOnClick(
                    interactionSource = interactionSource
                )
                .size(200.dp)
                .background(Color.Red)
        )
    }
}

private const val DEFAULT_SCALE_VALUE = 0.95f
private val PRESS_RELEASE_DELAY = 150.milliseconds