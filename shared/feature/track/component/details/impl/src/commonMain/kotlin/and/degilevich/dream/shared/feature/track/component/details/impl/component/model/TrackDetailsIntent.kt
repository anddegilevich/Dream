package and.degilevich.dream.shared.feature.track.component.details.impl.component.model

sealed interface TrackDetailsIntent {
    data object OnBackClicked : TrackDetailsIntent
}