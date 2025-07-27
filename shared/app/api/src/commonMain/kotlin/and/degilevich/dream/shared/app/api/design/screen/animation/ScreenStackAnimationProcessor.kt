package and.degilevich.dream.shared.app.api.design.screen.animation

import and.degilevich.dream.shared.app.api.component.children.Screen
import and.degilevich.dream.shared.foundation.decompose.compose.animation.defaultStackAnimator
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import com.arkivanov.decompose.Child
import com.arkivanov.decompose.extensions.compose.stack.animation.Direction
import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimator
import com.arkivanov.decompose.extensions.compose.stack.animation.fade

internal class ScreenStackAnimationProcessor {

    private val navbarScreensConfigs = setOf(
        ScreenConfig.Dashboard::class,
        ScreenConfig.Search::class
    )

    fun process(
        child: Child.Created<ScreenConfig, Screen>,
        otherChild: Child.Created<ScreenConfig, Screen>,
        direction: Direction,
    ): StackAnimator {
        val config = child.configuration
        val otherConfig = otherChild.configuration
        return when {
            isAnyInstanceSplash(
                config = config,
                otherConfig = otherConfig
            ) -> fade()

            isNavbarConfig(config) && isNavbarConfig(config) -> {
                fade()
            }

            else -> defaultStackAnimator(direction)
        }
    }

    private fun isAnyInstanceSplash(
        config: ScreenConfig,
        otherConfig: ScreenConfig
    ): Boolean {
        return sequence {
            yield(config)
            yield(otherConfig)
        }.any {
            it is ScreenConfig.Splash
        }
    }

    private fun isNavbarConfig(config: ScreenConfig): Boolean {
        return navbarScreensConfigs.any { kClass -> kClass.isInstance(config) }
    }
}