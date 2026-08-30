package and.degilevich.dream.shared.feature.common.component.topbar.impl.component

import and.degilevich.dream.shared.feature.base.component.impl.BaseDomainComponent
import and.degilevich.dream.shared.feature.common.component.drawer.api.component.DrawerManager
import and.degilevich.dream.shared.feature.common.component.topbar.impl.component.model.TopbarIntent
import and.degilevich.dream.shared.feature.common.component.topbar.impl.component.model.TopbarSideEffect
import and.degilevich.dream.shared.feature.common.component.topbar.impl.component.model.TopbarState
import and.degilevich.dream.shared.feature.user.domain.api.usecase.ObserveCurrentUserUseCase
import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnCreate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.core.component.inject

internal class TopbarDomainComponent(
    componentContext: ComponentContext
) : BaseDomainComponent<
    TopbarState,
    TopbarIntent,
    TopbarSideEffect
    >(
    componentContext = componentContext,
    stateConservator = TopbarStateConservator()
) {

    private val observeCurrentUserUseCase: ObserveCurrentUserUseCase by inject()
    private val drawerManager: DrawerManager by inject()

    init {
        subscribeToLifecycle()
    }

    override fun handleIntent(intent: TopbarIntent) {
        when (intent) {
            is TopbarIntent.OnAvatarClicked -> onAvatarClicked()
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

    private fun onAvatarClicked() {
        drawerManager.open()
    }

    private fun setUser(user: UserData) = reduce {
        copy(
            user = user,
            isLoading = false
        )
    }
}
