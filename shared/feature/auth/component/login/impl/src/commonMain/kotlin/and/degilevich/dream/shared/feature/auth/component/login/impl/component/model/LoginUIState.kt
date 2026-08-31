package and.degilevich.dream.shared.feature.auth.component.login.impl.component.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import androidx.compose.runtime.Immutable

@Immutable
data class LoginUIState(
    val isLoadingLoginButton: Boolean,
    val isEnabledLoginButton: Boolean
) {

    companion object : EmptyFactory<LoginUIState> {

        override fun empty(): LoginUIState {
            return LoginUIState(
                isLoadingLoginButton = false,
                isEnabledLoginButton = true
            )
        }
    }
}
