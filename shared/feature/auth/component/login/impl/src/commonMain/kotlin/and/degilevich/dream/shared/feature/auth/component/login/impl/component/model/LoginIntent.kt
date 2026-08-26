package and.degilevich.dream.shared.feature.auth.component.login.impl.component.model

sealed interface LoginIntent {
    data object OnLoginClicked : LoginIntent
}
