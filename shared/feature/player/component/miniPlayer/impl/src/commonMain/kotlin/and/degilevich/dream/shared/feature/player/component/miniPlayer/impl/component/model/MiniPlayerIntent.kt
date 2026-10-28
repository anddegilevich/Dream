package and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.component.model

sealed interface MiniPlayerIntent {
    data object OnViewClicked : MiniPlayerIntent
    data object OnSkipToPreviousClicked : MiniPlayerIntent
    data object OnSkipToNextClicked : MiniPlayerIntent
    data object OnShuffleClicked : MiniPlayerIntent
}
