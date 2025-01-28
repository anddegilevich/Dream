package and.degilevich.dream.shared.feature.artist.component.list.api.component

sealed interface ArtistListIntent {
    data class OnArtistClicked(val id: String) : ArtistListIntent
}