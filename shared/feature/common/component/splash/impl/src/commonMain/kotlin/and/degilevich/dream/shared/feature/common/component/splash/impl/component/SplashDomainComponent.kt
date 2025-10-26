package and.degilevich.dream.shared.feature.common.component.splash.impl.component

import and.degilevich.dream.shared.feature.common.component.splash.api.component.model.SplashIntent
import and.degilevich.dream.shared.feature.common.component.splash.api.component.model.SplashSideEffect
import and.degilevich.dream.shared.feature.common.component.splash.impl.component.model.SplashState
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import and.degilevich.dream.shared.template.component.impl.BaseDomainComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.essenty.lifecycle.doOnStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

internal class SplashDomainComponent(
    componentContext: ComponentContext
) : BaseDomainComponent<SplashState, SplashIntent, SplashSideEffect>(
    componentContext = componentContext,
    stateConservator = SplashStateConservator()
) {

    init {
        subscribeToLifecycle()
    }

    private fun subscribeToLifecycle() {
        doOnStart {
            processNavigation()
        }
    }

    private fun processNavigation() {
        scope.launch {
            delay(1.seconds)
            navigateToHomePage()
        }
    }

    private fun navigateToHomePage() {
        navigator.screenNavigator.replaceCurrent(ScreenConfig.Dashboard)
    }
}