package and.degilevich.dream.shared.feature.artist.component.details.api.component.model

sealed interface ArtistDetailsIntent {
    data object OnBackClicked : ArtistDetailsIntent
}