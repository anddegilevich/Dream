package and.degilevich.dream.shared.feature.playlist.component.details.impl.component

import and.degilevich.dream.Res
import and.degilevich.dream.shared.feature.playlist.component.details.impl.component.model.PlaylistDetailsHeaderUIData
import and.degilevich.dream.shared.feature.playlist.component.details.impl.component.model.PlaylistDetailsState
import and.degilevich.dream.shared.feature.playlist.component.details.impl.component.model.PlaylistDetailsUIState
import and.degilevich.dream.shared.feature.playlist.ui.api.mapper.TrackDataToPlaylistTrackCardUIDataMapper
import and.degilevich.dream.shared.feature.playlist.ui.api.model.PlaylistTrackCardUIData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import and.degilevich.dream.shared.resource.api.ResourceManager
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class PlaylistDetailsUIStateMapper : Mapper<PlaylistDetailsState, PlaylistDetailsUIState>, KoinComponent {

    private val trackDataToPlaylistTrackCardUIDataMapper: TrackDataToPlaylistTrackCardUIDataMapper by inject()
    private val resourceManager: ResourceManager by inject()

    override fun map(item: PlaylistDetailsState): PlaylistDetailsUIState = with(item) {
        PlaylistDetailsUIState(
            header = mapToHeader(state = this),
            count = mapToCount(state = this),
            tracks = mapToTracks(state = this),
            isLoadingTracks = isLoadingTracks
        )
    }

    private fun mapToHeader(state: PlaylistDetailsState): Skeleton<PlaylistDetailsHeaderUIData> = with(state) {
        Skeleton.from(
            isLoading = playlist.isEmpty()
        ) {
            PlaylistDetailsHeaderUIData(
                coverUrl = playlist.images.firstOrNull()?.url.orEmpty(),
                name = playlist.name,
                description = playlist.description,
                isVisibleDescription = playlist.description.isNotBlank()
            )
        }
    }

    private fun mapToCount(state: PlaylistDetailsState): Skeleton<String> = with(state) {
        Skeleton.from(
            isLoading = total == 0 && !isLoadingTracks
        ) {
            resourceManager.getString(Res.plurals.plural_song, total)
        }
    }

    private fun mapToTracks(
        state: PlaylistDetailsState
    ): Skeleton<ImmutableList<PlaylistTrackCardUIData>> = with(state) {
        Skeleton.from(
            isLoading = tracks.isEmpty() && isLoadingTracks
        ) {
            tracks
                .mapIndexed { index, playlistTrack ->
                    trackDataToPlaylistTrackCardUIDataMapper
                        .map(playlistTrack.track)
                        .copy(number = (index + 1).toString())
                }
                .toImmutableList()
        }
    }
}
