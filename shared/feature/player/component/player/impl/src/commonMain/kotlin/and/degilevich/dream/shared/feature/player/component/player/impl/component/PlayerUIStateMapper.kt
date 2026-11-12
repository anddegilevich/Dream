package and.degilevich.dream.shared.feature.player.component.player.impl.component

import and.degilevich.dream.shared.feature.player.component.player.impl.component.model.PlayerState
import and.degilevich.dream.shared.feature.player.component.player.impl.component.model.PlayerUIState
import and.degilevich.dream.shared.feature.player.ui.api.mapper.PlaybackStateDataToPlaybackProgressUIDataMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shated.feature.track.ui.api.mapper.TrackInfoToTrackCardInfoUIDataMapper
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class PlayerUIStateMapper : Mapper<PlayerState, PlayerUIState>, KoinComponent {

    private val trackInfoToTrackCardInfoUIDataMapper: TrackInfoToTrackCardInfoUIDataMapper by inject()
    private val playbackStateDataToPlaybackProgressUIDataMapper: PlaybackStateDataToPlaybackProgressUIDataMapper by inject()

    override fun map(item: PlayerState): PlayerUIState = with(item) {
        PlayerUIState(
            coverUrl = playbackState.track.album.images.firstOrNull()?.url.orEmpty(),
            track = trackInfoToTrackCardInfoUIDataMapper.map(playbackState.track),
            progress = playbackStateDataToPlaybackProgressUIDataMapper.map(playbackState),
            isShuffling = playbackState.isShuffling
        )
    }
}
