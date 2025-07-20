package and.degilevich.dream.shared.feature.album.component.details.api.component.model

sealed interface AlbumDetailsIntent {
    data object OnBackClicked : AlbumDetailsIntent
    data class OnArtistClicked(val id: String) : AlbumDetailsIntent
    data class OnTrackClicked(val id: String) : AlbumDetailsIntent
}