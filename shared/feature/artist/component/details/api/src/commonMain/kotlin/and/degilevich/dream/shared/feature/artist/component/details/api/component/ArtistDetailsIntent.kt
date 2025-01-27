package and.degilevich.dream.shared.feature.artist.component.details.api.component

sealed interface ArtistDetailsIntent {
    class OnSubscribeClicked : ArtistDetailsIntent
    class OnSimilarArtistClicked(val id: String) : ArtistDetailsIntent
}