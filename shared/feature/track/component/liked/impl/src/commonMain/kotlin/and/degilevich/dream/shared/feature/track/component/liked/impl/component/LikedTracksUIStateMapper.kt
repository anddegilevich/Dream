package and.degilevich.dream.shared.feature.track.component.liked.impl.component

import and.degilevich.dream.Res
import and.degilevich.dream.shared.feature.playlist.ui.api.mapper.TrackDataToPlaylistTrackCardUIDataMapper
import and.degilevich.dream.shared.feature.playlist.ui.api.model.PlaylistTrackCardUIData
import and.degilevich.dream.shared.feature.track.component.liked.impl.component.model.LikedTracksState
import and.degilevich.dream.shared.feature.track.component.liked.impl.component.model.LikedTracksUIState
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import and.degilevich.dream.shared.resource.api.ResourceManager
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class LikedTracksUIStateMapper : Mapper<LikedTracksState, LikedTracksUIState>, KoinComponent {

    private val trackDataToPlaylistTrackCardUIDataMapper: TrackDataToPlaylistTrackCardUIDataMapper by inject()
    private val resourceManager: ResourceManager by inject()

    override fun map(item: LikedTracksState): LikedTracksUIState = with(item) {
        LikedTracksUIState(
            count = mapToCount(state = this),
            tracks = mapToTracks(state = this),
            isLoadingTracks = isLoadingTracks
        )
    }

    private fun mapToCount(state: LikedTracksState): Skeleton<String> = with(state) {
        Skeleton.from(isLoading = total == 0 && !isLoadingTracks) {
            resourceManager.getString(Res.plurals.plural_song, total)
        }
    }

    private fun mapToTracks(state: LikedTracksState): Skeleton<ImmutableList<PlaylistTrackCardUIData>> = with(state) {
        Skeleton.from(
            isLoading = tracks.isEmpty() && isLoadingTracks
        ) {
            tracks
                .mapIndexed { index, savedTrack ->
                    trackDataToPlaylistTrackCardUIDataMapper
                        .map(savedTrack.track)
                        .copy(number = (index + 1).toString())
                }
                .toImmutableList()
        }
    }
}
