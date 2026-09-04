package and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.preview

import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.component.model.RecentlyPlayedUIState
import and.degilevich.dream.shared.feature.playlist.ui.api.model.PlaylistTrackCardUIData
import and.degilevich.dream.shared.foundation.abstraction.id.identifier
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider
import and.degilevich.dream.shated.feature.track.ui.api.preview.TrackCardInfoUIDataPreviewProvider
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

class RecentlyPlayedUIStatePreviewProvider : LabeledPreviewParameterProvider<RecentlyPlayedUIState>() {

    private val trackCardInfoUIDataPreviewProvider = TrackCardInfoUIDataPreviewProvider()

    override val labeledValues = listOf(
        "Skeleton" to provideSkeleton(),
        "Default" to provideDefault()
    )

    fun provideSkeleton(): RecentlyPlayedUIState {
        return RecentlyPlayedUIState.empty()
    }

    fun provideDefault(): RecentlyPlayedUIState {
        return RecentlyPlayedUIState(items = Skeleton.Value(provideList()))
    }

    fun provideList(): ImmutableList<PlaylistTrackCardUIData> {
        return List(RECENTLY_PLAYED_PREVIEW_COUNT) { index ->
            PlaylistTrackCardUIData(
                id = identifier(value = index.toString()),
                number = (index + 1).toString(),
                info = trackCardInfoUIDataPreviewProvider.provide(index = index),
                albumCoverUrl = ""
            )
        }.toImmutableList()
    }

    private companion object {
        const val RECENTLY_PLAYED_PREVIEW_COUNT = 10
    }
}
