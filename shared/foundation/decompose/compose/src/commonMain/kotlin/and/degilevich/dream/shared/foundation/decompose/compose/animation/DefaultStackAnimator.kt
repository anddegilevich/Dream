package and.degilevich.dream.shared.foundation.decompose.compose.animation

import androidx.compose.animation.core.tween
import com.arkivanov.decompose.extensions.compose.stack.animation.Direction
import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimator
import com.arkivanov.decompose.extensions.compose.stack.animation.slide

fun defaultStackAnimator(
    direction: Direction
): StackAnimator {
    val animationDuration = when (direction) {
        Direction.ENTER_FRONT -> StackAnimationConst.ENTER_FRONT_DURATION_MS
        Direction.ENTER_BACK -> StackAnimationConst.ENTER_BACK_DURATION_MS
        Direction.EXIT_FRONT -> StackAnimationConst.EXIT_FRONT_DURATION_MS
        Direction.EXIT_BACK -> StackAnimationConst.EXIT_BACK_DURATION_MS
    }
    return slide(
        animationSpec = tween(durationMillis = animationDuration.inWholeMilliseconds.toInt())
    )
}