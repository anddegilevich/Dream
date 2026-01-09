package and.degilevich.dream.shared.feature.artist.component.details.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.id.Identifier

sealed interface ArtistDetailsIntent {
    data object OnBackClicked : ArtistDetailsIntent
    data class OnTrackClicked(val id: Identifier) : ArtistDetailsIntent
    data class OnAlbumClicked(val id: Identifier) : ArtistDetailsIntent
}