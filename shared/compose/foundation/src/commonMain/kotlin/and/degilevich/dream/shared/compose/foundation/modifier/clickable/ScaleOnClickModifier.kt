package and.degilevich.dream.shared.compose.foundation.modifier.clickable

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.scale

fun Modifier.scaleOnClick(
    scale: Float = 0.95f, //FIXME: Default value const
    interactionSource: MutableInteractionSource? = null,
    isEnabled: Boolean = true,
): Modifier {
    return composed {
        val mutableInteractionSource = remember(interactionSource) {
            interactionSource ?: MutableInteractionSource()
        }
        val isPressed = mutableInteractionSource.isPressedWithDelay()
        val scaleState by animateFloatAsState(
            targetValue = if (isPressed && isEnabled) scale else 1f,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )
        this
            .scale(scaleState)
            .clickable(
                enabled = isEnabled,
                interactionSource = mutableInteractionSource,
                indication = null
            ) {}
    }
}