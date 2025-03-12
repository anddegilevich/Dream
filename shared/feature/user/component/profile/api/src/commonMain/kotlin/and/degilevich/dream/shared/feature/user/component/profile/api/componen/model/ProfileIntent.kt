package and.degilevich.dream.shared.feature.user.component.profile.api.componen.model

sealed interface ProfileIntent {
    data object OnIconClicked : ProfileIntent
    data object OnBackClicked : ProfileIntent
    data class OnPhotoPicked(
        val uri: String
    ) : ProfileIntent
}