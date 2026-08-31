package and.degilevich.dream.shared.feature.auth.component.login.impl.component

import and.degilevich.dream.shared.feature.auth.component.login.api.component.LoginComponent
import and.degilevich.dream.shared.feature.auth.component.login.impl.component.model.LoginIntent
import and.degilevich.dream.shared.feature.auth.component.login.impl.component.model.LoginSideEffect
import and.degilevich.dream.shared.feature.auth.component.login.impl.component.model.LoginState
import and.degilevich.dream.shared.feature.auth.component.login.impl.component.model.LoginUIState
import and.degilevich.dream.shared.feature.auth.component.login.impl.view.LoginScreen
import and.degilevich.dream.shared.feature.base.component.impl.BaseBinderComponent
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext

internal class LoginComponentImpl(
    componentContext: ComponentContext
) : BaseBinderComponent<LoginUIState, LoginIntent, LoginSideEffect, LoginState>(
    componentContext = componentContext,
    domainComponentFactory = { childComponentContext ->
        LoginDomainComponent(componentContext = childComponentContext)
    },
    uiStateMapper = LoginUIStateMapper(),
    initialUIState = LoginUIState.empty()
),
    LoginComponent {

    @Composable
    override fun Render() {
        LoginScreen(
            state = state(),
            onIntent = ::handleIntent
        )
    }
}
