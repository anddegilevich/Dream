package and.degilevich.dream.shared.feature.common.component.drawer.impl.component

import and.degilevich.dream.shared.feature.auth.domain.api.usecase.LogoutUseCase
import and.degilevich.dream.shared.feature.base.component.impl.BaseDomainComponent
import and.degilevich.dream.shared.feature.common.component.drawer.api.component.DrawerManager
import and.degilevich.dream.shared.feature.common.component.drawer.impl.component.model.DrawerIntent
import and.degilevich.dream.shared.feature.common.component.drawer.impl.component.model.DrawerSideEffect
import and.degilevich.dream.shared.feature.common.component.drawer.impl.component.model.DrawerState
import and.degilevich.dream.shared.feature.user.domain.api.usecase.ObserveCurrentUserUseCase
import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import and.degilevich.dream.shared.foundation.decompose.navigation.ext.replaceAll
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnCreate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

internal class DrawerDomainComponent(
    componentContext: ComponentContext
) : BaseDomainComponent<
        DrawerState,
        DrawerIntent,
        DrawerSideEffect
        >(
    componentContext = componentContext,
    stateConservator = DrawerStateConservator()
) {

    private val drawerManager: DrawerManager by inject()
    private val observeCurrentUserUseCase: ObserveCurrentUserUseCase by inject()
    private val logoutUseCase: LogoutUseCase by inject()

    init {
        subscribeToLifecycle()
    }

    override fun handleIntent(intent: DrawerIntent) {
        when (intent) {
            is DrawerIntent.OnLogoutClicked -> onLogoutClicked()
        }
    }

    private fun subscribeToLifecycle() {
        doOnCreate {
            observeCurrentUser()
        }
    }

    private fun observeCurrentUser() = observeCurrentUserUseCase()
        .flowOn(context = Dispatchers.IO)
        .onEach { user ->
            setUser(user)
        }.launchIn(scope)

    private fun onLogoutClicked() = scope.launch {
        withContext(context = Dispatchers.IO) { logoutUseCase() }
            .onSuccess {
                drawerManager.close()
                navigateToLogin()
            }
            .onFailure { error ->
                toastController.showMessageToast(error = error)
            }
    }

    private fun navigateToLogin() {
        navigator.screenNavigator.replaceAll(configs = listOf(ScreenConfig.Login))
    }

    private fun setUser(user: UserData) = reduce {
        copy(user = user)
    }
}
