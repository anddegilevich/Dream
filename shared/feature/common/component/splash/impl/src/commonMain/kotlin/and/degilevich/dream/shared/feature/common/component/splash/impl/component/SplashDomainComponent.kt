package and.degilevich.dream.shared.feature.common.component.splash.impl.component

import and.degilevich.dream.shared.feature.auth.domain.api.usecase.HasActiveSessionUseCase
import and.degilevich.dream.shared.feature.base.component.impl.BaseDomainComponent
import and.degilevich.dream.shared.feature.common.component.splash.impl.component.model.SplashIntent
import and.degilevich.dream.shared.feature.common.component.splash.impl.component.model.SplashSideEffect
import and.degilevich.dream.shared.feature.common.component.splash.impl.component.model.SplashState
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.replaceCurrent
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

    override fun handleIntent(intent: SplashIntent) {
        when (intent) {
            is SplashIntent.OnIntroFinished -> onIntroFinished()
        }
    }

    private fun onIntroFinished() {
        processNavigation()
    }

    private fun processNavigation() = scope.launch {
        val hasActiveSession = withContext(context = Dispatchers.IO) { hasActiveSessionUseCase() }
        if (hasActiveSession) {
            replaceSplashWith(ScreenConfig.Home)
        } else {
            replaceSplashWith(ScreenConfig.Login)
        }
    }

    private fun replaceSplashWith(destination: ScreenConfig) {
        navigator.screenNavigator.replaceCurrent(destination)
    }
}
