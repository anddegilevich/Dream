package and.degilevich.dream.shared.feature.track.component.details.api.component.model

sealed interface TrackDetailsIntent {
    data object OnBackClicked : TrackDetailsIntent
}