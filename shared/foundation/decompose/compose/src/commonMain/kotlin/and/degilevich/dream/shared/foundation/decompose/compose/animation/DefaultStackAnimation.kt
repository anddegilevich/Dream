package and.degilevich.dream.shared.foundation.decompose.compose.animation

import com.arkivanov.decompose.FaultyDecomposeApi
import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimation
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation

@OptIn(FaultyDecomposeApi::class)
fun <Config : Any, Child : Any> defaultStackAnimation(): StackAnimation<Config, Child> {
    return stackAnimation { _, _, direction ->
        defaultStackAnimator(direction = direction)
    }
}