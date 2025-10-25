package and.degilevich.dream.shared.feature.track.component.details.impl.component

import and.degilevich.dream.shared.feature.artist.design.api.mapper.ArtistsInfoToStringMapper
import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsInfoLayoutUIData
import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsUIState
import and.degilevich.dream.shared.feature.track.component.details.impl.component.model.TrackDetailsState
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class TrackDetailsUIStateMapper : Mapper<TrackDetailsState, TrackDetailsUIState>, KoinComponent {

    private val artistsInfoToStringMapper: ArtistsInfoToStringMapper by inject()

    override fun map(item: TrackDetailsState): TrackDetailsUIState {
        return TrackDetailsUIState(
            info = mapToInfo(state = item)
        )
    }

    private fun mapToInfo(state: TrackDetailsState): Skeleton<TrackDetailsInfoLayoutUIData> {
        return with(state) {
            if (track.isEmpty()) {
                Skeleton.Loading
            } else {
                Skeleton.Value(
                    value = TrackDetailsInfoLayoutUIData(
                        album = track.album.name,
                        albumIconUrl = track.album.images.firstOrNull()?.url.orEmpty(),
                        name = track.name,
                        artists = artistsInfoToStringMapper.map(track.artists)
                    )
                )
            }
        }
    }
}