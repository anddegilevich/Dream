package and.degilevich.dream.shared.feature.artist.component.details.impl.store.model

import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData

sealed interface ArtistDetailsMessage {
    data class SetLoading(val isLoading: Boolean) : ArtistDetailsMessage
    data class SetArtist(val artist: ArtistData) : ArtistDetailsMessage
    data class SetSimilarArtists(val artists: List<ArtistData>) : ArtistDetailsMessage
}