package and.degilevich.dream.shared.feature.player.component.player.impl.component.model

sealed interface PlayerIntent {
    data object OnBackClicked : PlayerIntent
    data object OnSkipToPreviousClicked : PlayerIntent
    data object OnSkipToNextClicked : PlayerIntent
    data object OnShuffleClicked : PlayerIntent
    data object OnPlayClicked : PlayerIntent
}
