package and.degilevich.dream.shared.feature.artist.component.list.impl.store.model

import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData

sealed interface ArtistListMessage {
    data class SetLoading(val isLoading: Boolean) : ArtistListMessage
    data class SetArtists(val artists: List<ArtistData>) : ArtistListMessage
}