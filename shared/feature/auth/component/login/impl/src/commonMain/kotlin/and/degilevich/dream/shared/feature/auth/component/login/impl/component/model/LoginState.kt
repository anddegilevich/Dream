package and.degilevich.dream.shared.feature.auth.component.login.impl.component.model

import kotlinx.serialization.Serializable

@Serializable
data class LoginState(
    val isLoading: Boolean
)
