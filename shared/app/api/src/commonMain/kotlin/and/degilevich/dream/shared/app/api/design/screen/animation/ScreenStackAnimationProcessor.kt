package and.degilevich.dream.shared.app.api.design.screen.animation

import and.degilevich.dream.shared.app.api.component.children.Screen
import and.degilevich.dream.shared.foundation.decompose.compose.animation.defaultStackAnimator
import and.degilevich.dream.shared.navigation.api.config.ScreenConfig
import com.arkivanov.decompose.Child
import com.arkivanov.decompose.extensions.compose.stack.animation.Direction
import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimator
import com.arkivanov.decompose.extensions.compose.stack.animation.fade

internal class ScreenStackAnimationProcessor {

    fun process(
        child: Child.Created<ScreenConfig, Screen>,
        otherChild: Child.Created<ScreenConfig, Screen>,
        direction: Direction,
    ): StackAnimator {
        val instance = child.instance
        val otherInstance = otherChild.instance
        return when {
            isAnyInstanceSplash(
                instance = instance,
                otherInstance = otherInstance
            ) -> fade()

            else -> defaultStackAnimator(direction)
        }
    }

    private fun isAnyInstanceSplash(
        instance: Screen,
        otherInstance: Screen
    ): Boolean {
        return listOf(otherInstance, instance).any { it is Screen.Splash }
    }
}