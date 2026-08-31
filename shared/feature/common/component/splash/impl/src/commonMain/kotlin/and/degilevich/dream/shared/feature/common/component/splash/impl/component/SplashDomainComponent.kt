package and.degilevich.dream.shared.feature.common.component.splash.impl.component

import and.degilevich.dream.shared.feature.auth.domain.api.usecase.HasActiveSessionUseCase
import and.degilevich.dream.shared.feature.base.component.impl.BaseDomainComponent
import and.degilevich.dream.shared.feature.common.component.splash.impl.component.model.SplashIntent
import and.degilevich.dream.shared.feature.common.component.splash.impl.component.model.SplashSideEffect
import and.degilevich.dream.shared.feature.common.component.splash.impl.component.model.SplashState
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.essenty.lifecycle.doOnStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

internal class SplashDomainComponent(
    componentContext: ComponentContext
) : BaseDomainComponent<SplashState, SplashIntent, SplashSideEffect>(
    componentContext = componentContext,
    stateConservator = SplashStateConservator()
) {

    private val hasActiveSessionUseCase: HasActiveSessionUseCase by inject()

    init {
        subscribeToLifecycle()
    }

    private fun subscribeToLifecycle() {
        doOnStart {
            processNavigation()
        }
    }

    private fun processNavigation() = scope.launch {
        val hasActiveSession = withContext(context = Dispatchers.IO) { hasActiveSessionUseCase() }
        if (hasActiveSession) {
            navigateToHome()
        } else {
            navigateToLogin()
        }
    }

    private fun navigateToHome() {
        navigator.screenNavigator.replaceCurrent(ScreenConfig.Home)
    }

    private fun navigateToLogin() {
        navigator.screenNavigator.replaceCurrent(ScreenConfig.Login)
    }
}