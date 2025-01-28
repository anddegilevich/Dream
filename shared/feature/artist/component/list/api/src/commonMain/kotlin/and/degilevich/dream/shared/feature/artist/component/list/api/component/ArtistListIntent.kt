package and.degilevich.dream.shared.feature.artist.component.list.api.component

sealed interface ArtistListIntent {
    class OnArtistClicked(val id: String) : ArtistListIntent
}