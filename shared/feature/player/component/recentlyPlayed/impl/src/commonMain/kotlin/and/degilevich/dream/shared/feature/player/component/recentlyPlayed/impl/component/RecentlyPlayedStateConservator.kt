package and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.component

import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.component.model.RecentlyPlayedState
import and.degilevich.dream.shared.foundation.decompose.component.mvi.conservator.ComponentStateConservator
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import kotlinx.serialization.KSerializer

internal class RecentlyPlayedStateConservator : ComponentStateConservator<RecentlyPlayedState> {
    override val key: String = RecentlyPlayedState::class.className()
    override val initialState: RecentlyPlayedState = RecentlyPlayedState(
        isLoading = true,
        items = emptyList()
    )
    override val serializer: KSerializer<RecentlyPlayedState> = RecentlyPlayedState.serializer()
}
