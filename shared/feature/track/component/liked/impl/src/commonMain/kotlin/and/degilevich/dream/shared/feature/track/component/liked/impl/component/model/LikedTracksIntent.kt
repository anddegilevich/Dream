package and.degilevich.dream.shared.feature.track.component.liked.impl.component.model

import and.degilevich.dream.shared.foundation.abstraction.id.Identifier

sealed interface LikedTracksIntent {
    data object OnBackClicked : LikedTracksIntent
    data object OnNextPageRequested : LikedTracksIntent
    data class OnTrackClicked(val id: Identifier) : LikedTracksIntent
}
