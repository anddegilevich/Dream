package and.degilevich.dream.shared.feature.auth.component.login.impl.preview

import and.degilevich.dream.shared.feature.auth.component.login.impl.component.model.LoginUIState
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider

class LoginUIStatePreviewProvider : LabeledPreviewParameterProvider<LoginUIState>() {

    override val labeledValues = listOf(
        "Default" to provideDefault(),
        "Loading" to provideLoading()
    )

    fun provideDefault(): LoginUIState {
        return LoginUIState(
            isLoadingLoginButton = false,
            isEnabledLoginButton = true
        )
    }

    fun provideLoading(): LoginUIState {
        return LoginUIState(
            isLoadingLoginButton = true,
            isEnabledLoginButton = false
        )
    }
}
