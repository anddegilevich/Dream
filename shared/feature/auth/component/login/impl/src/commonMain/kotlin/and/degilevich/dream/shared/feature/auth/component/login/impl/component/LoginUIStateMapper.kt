package and.degilevich.dream.shared.feature.auth.component.login.impl.component

import and.degilevich.dream.shared.feature.auth.component.login.impl.component.model.LoginState
import and.degilevich.dream.shared.feature.auth.component.login.impl.component.model.LoginUIState
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

internal class LoginUIStateMapper : Mapper<LoginState, LoginUIState> {

    override fun map(item: LoginState): LoginUIState = with(item) {
        LoginUIState(
            isLoadingLoginButton = isLoading,
            isEnabledLoginButton = !isLoading
        )
    }
}
