package and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.component

import and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.component.model.MiniPlayerState
import and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.component.model.MiniPlayerUIState
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shated.feature.track.ui.api.mapper.TrackInfoToTrackCardInfoUIDataMapper
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class MiniPlayerUIStateMapper : Mapper<MiniPlayerState, MiniPlayerUIState>, KoinComponent {

    private val trackInfoToTrackCardInfoUIDataMapper: TrackInfoToTrackCardInfoUIDataMapper by inject()

    override fun map(item: MiniPlayerState): MiniPlayerUIState = with(item) {
        MiniPlayerUIState(
            coverUrl = playbackState.track.album.images.firstOrNull()?.url.orEmpty(),
            track = trackInfoToTrackCardInfoUIDataMapper.map(playbackState.track),
            isShuffling = playbackState.isShuffling,
            isPlaying = playbackState.isPlaying
        )
    }
}
