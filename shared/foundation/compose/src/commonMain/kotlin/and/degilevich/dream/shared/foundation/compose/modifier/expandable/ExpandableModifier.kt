package and.degilevich.dream.shared.foundation.compose.modifier.expandable

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.layout

fun Modifier.expandable(
    progress: Float,
    orientation: ExpandableOrientation = ExpandableOrientation.VERTICAL
): Modifier {
    return this
        .alpha(progress)
        .layout { measurable, constraints ->
            val placeable = measurable.measure(constraints)
            with(placeable) {
                val width = when (orientation) {
                    ExpandableOrientation.VERTICAL -> width
                    ExpandableOrientation.HORIZONTAL -> (width * progress).toInt()
                }
                val height = when (orientation) {
                    ExpandableOrientation.VERTICAL -> (height * progress).toInt()
                    ExpandableOrientation.HORIZONTAL -> height
                }
                layout(width, height) {
                    placeRelative(0, 0)
                }
            }
        }
}

fun Modifier.expandable(
    isExpanded: Boolean,
    orientation: ExpandableOrientation = ExpandableOrientation.VERTICAL,
    animationSpec: AnimationSpec<Float> = TweenSpec(),
    onExpanded: () -> Unit = {},
    onShrunk: () -> Unit = {},
): Modifier {
    return this.composed {
        val progress by animateFloatAsState(
            targetValue = if (isExpanded) 1f else 0f,
            animationSpec = animationSpec,
            finishedListener = { currentProgress ->
                when (currentProgress) {
                    0f -> onShrunk()
                    1f -> onExpanded()
                }
            },
            label = PROGRESS
        )

        this.expandable(
            progress = progress,
            orientation = orientation
        )
    }
}

private const val PROGRESS = "progress"