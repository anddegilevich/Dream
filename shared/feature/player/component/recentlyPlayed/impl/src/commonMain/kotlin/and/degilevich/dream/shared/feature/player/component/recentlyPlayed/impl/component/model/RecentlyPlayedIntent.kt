package and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.component.model

import and.degilevich.dream.shared.foundation.abstraction.id.Identifier

sealed interface RecentlyPlayedIntent {
    data class OnTrackClicked(val id: Identifier) : RecentlyPlayedIntent
}
