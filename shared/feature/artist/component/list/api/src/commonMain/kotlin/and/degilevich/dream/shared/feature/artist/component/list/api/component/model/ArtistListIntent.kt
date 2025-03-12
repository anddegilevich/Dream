package and.degilevich.dream.shared.feature.artist.component.list.api.component.model

sealed interface ArtistListIntent {
    data class OnArtistClicked(val id: String) : ArtistListIntent
    data object OnProfileClicked : ArtistListIntent
}