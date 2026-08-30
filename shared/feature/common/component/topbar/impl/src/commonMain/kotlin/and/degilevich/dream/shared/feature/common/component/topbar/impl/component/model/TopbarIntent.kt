package and.degilevich.dream.shared.feature.common.component.topbar.impl.component.model

sealed interface TopbarIntent {
    data object OnAvatarClicked : TopbarIntent
}
