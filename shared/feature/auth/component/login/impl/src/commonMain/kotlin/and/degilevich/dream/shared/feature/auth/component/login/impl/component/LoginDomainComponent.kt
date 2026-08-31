package and.degilevich.dream.shared.feature.auth.component.login.impl.component

import and.degilevich.dream.Res
import and.degilevich.dream.shared.feature.auth.component.login.impl.component.model.LoginIntent
import and.degilevich.dream.shared.feature.auth.component.login.impl.component.model.LoginSideEffect
import and.degilevich.dream.shared.feature.auth.component.login.impl.component.model.LoginState
import and.degilevich.dream.shared.feature.auth.domain.api.usecase.LoginUseCase
import and.degilevich.dream.shared.feature.base.component.impl.BaseDomainComponent
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.replaceCurrent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

internal class LoginDomainComponent(
    componentContext: ComponentContext
) : BaseDomainComponent<LoginState, LoginIntent, LoginSideEffect>(
    componentContext = componentContext,
    stateConservator = LoginStateConservator()
) {

    private val loginUseCase: LoginUseCase by inject()

    override fun handleIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.OnLoginClicked -> login()
        }
    }

    private fun login() = scope.launch {
        try {
            setLoading(isLoading = true)
            withContext(Dispatchers.IO) { loginUseCase() }
                .onSuccess { navigateToHome() }
                .onFailure { reportLoginFailure() }
        } finally {
            setLoading(isLoading = false)
        }
    }

    private suspend fun reportLoginFailure() {
        toastController.showMessageToast(resource = Res.strings.error_authentication_failed)
    }

    private fun navigateToHome() {
        navigator.screenNavigator.replaceCurrent(ScreenConfig.Home)
    }

    private fun setLoading(isLoading: Boolean) = reduce {
        copy(isLoading = isLoading)
    }
}
