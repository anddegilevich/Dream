package and.degilevich.dream.shared.feature.playlist.component.list.impl.component.model

import and.degilevich.dream.shared.foundation.abstraction.id.Identifier

sealed interface PlaylistListIntent {
    data class OnPlaylistClicked(val id: Identifier) : PlaylistListIntent
    data object OnLikedSongsClicked : PlaylistListIntent
}
