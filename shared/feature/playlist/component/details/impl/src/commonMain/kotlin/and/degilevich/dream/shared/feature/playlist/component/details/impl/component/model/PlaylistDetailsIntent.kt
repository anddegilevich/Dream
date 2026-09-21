package and.degilevich.dream.shared.feature.playlist.component.details.impl.component.model

import and.degilevich.dream.shared.foundation.abstraction.id.Identifier

sealed interface PlaylistDetailsIntent {
    data object OnBackClicked : PlaylistDetailsIntent
    data object OnNextPageRequested : PlaylistDetailsIntent
    data class OnTrackClicked(val id: Identifier) : PlaylistDetailsIntent
}
