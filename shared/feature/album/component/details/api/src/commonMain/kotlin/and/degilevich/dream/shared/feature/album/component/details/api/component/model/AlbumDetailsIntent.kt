package and.degilevich.dream.shared.feature.album.component.details.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.id.Identifier

sealed interface AlbumDetailsIntent {
    data object OnBackClicked : AlbumDetailsIntent
    data class OnArtistClicked(val id: Identifier) : AlbumDetailsIntent
    data class OnTrackClicked(val id: Identifier) : AlbumDetailsIntent
}