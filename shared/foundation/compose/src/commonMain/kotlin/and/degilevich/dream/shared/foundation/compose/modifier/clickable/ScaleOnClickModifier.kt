package and.degilevich.dream.shared.foundation.compose.modifier.clickable

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.scale

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

private const val DEFAULT_SCALE_VALUE = 0.95f