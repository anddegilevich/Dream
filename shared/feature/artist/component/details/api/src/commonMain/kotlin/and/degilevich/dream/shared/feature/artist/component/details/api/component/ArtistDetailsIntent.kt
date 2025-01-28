package and.degilevich.dream.shared.feature.artist.component.details.api.component

sealed interface ArtistDetailsIntent {
    data object OnSubscribeClicked : ArtistDetailsIntent
    data object OnBackCLicked : ArtistDetailsIntent
    data class OnSimilarArtistClicked(val id: String) : ArtistDetailsIntent
}