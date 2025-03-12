package and.degilevich.dream.shared.feature.user.component.profile.api.componen.model

sealed interface ProfileSideEffect {
    data object OpenFilePicker : ProfileSideEffect
}