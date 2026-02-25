package and.degilevich.dream.shared.foundation.compose.modifier.clickable

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

fun Modifier.scaleOnClick(
    interactionSource: MutableInteractionSource,
    scale: Float = DEFAULT_SCALE_VALUE,
    isEnabled: Boolean = true,
): Modifier {
    return composed {
        val isPressed by interactionSource.isPressedWithDelay()
        val scaleState by animateFloatAsState(
            targetValue = if (isPressed && isEnabled) scale else 1f,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )
        this.scale(scaleState)
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