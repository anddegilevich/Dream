package and.degilevich.dream.shared.feature.artist.component.details.impl.store.model

import and.degilevich.dream.shared.feature.artist.model.core.ArtistData

sealed interface ArtistDetailsMessage {
    data class SetLoading(val isLoading: Boolean) : ArtistDetailsMessage
    data class SetArtist(val artist: ArtistData) : ArtistDetailsMessage
}