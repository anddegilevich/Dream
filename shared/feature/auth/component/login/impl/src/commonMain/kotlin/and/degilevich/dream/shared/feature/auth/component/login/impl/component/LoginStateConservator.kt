package and.degilevich.dream.shared.feature.auth.component.login.impl.component

import and.degilevich.dream.shared.feature.auth.component.login.impl.component.model.LoginState
import and.degilevich.dream.shared.foundation.decompose.component.mvi.conservator.ComponentStateConservator
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import kotlinx.serialization.KSerializer

internal class LoginStateConservator : ComponentStateConservator<LoginState> {
    override val key: String = LoginState::class.className()
    override val initialState: LoginState = LoginState(isLoading = false)
    override val serializer: KSerializer<LoginState> = LoginState.serializer()
}
