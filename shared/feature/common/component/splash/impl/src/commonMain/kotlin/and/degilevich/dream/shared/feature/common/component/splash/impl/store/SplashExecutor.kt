package and.degilevich.dream.shared.feature.common.component.splash.impl.store

import and.degilevich.dream.shared.feature.common.component.splash.api.component.model.SplashIntent
import and.degilevich.dream.shared.feature.common.component.splash.api.component.model.SplashSideEffect
import and.degilevich.dream.shared.feature.common.component.splash.impl.store.model.SplashState
import and.degilevich.dream.shared.foundation.coroutine.dispatcher.ext.coroutine.withBackgroundContext
import and.degilevich.dream.shared.foundation.decompose.component.store.executor.ExecutorAbs
import and.degilevich.dream.shared.navigation.api.AppNavigator
import and.degilevich.dream.shared.navigation.api.config.ScreenConfig
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.doOnStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.time.Duration.Companion.seconds

internal class SplashExecutor(
    lifecycle: Lifecycle
) : ExecutorAbs<SplashState, SplashIntent, SplashSideEffect>(lifecycle), KoinComponent {

    private val navigator: AppNavigator by inject()

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
            withBackgroundContext { delay(1.seconds) }
            navigateToDashboard()
        }
    }

    private fun navigateToDashboard() {
        navigator.screenNavigator.replaceCurrent(ScreenConfig.Dashboard)
    }
}