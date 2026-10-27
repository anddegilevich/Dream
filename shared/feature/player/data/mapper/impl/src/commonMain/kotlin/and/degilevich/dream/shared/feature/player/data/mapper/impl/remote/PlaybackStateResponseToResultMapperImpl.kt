package and.degilevich.dream.shared.feature.player.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.CurrentlyPlayingContextObject
import and.degilevich.dream.shared.feature.player.data.mapper.api.remote.PlaybackStateOutputToDataMapper
import and.degilevich.dream.shared.feature.player.data.mapper.api.remote.PlaybackStateResponseToResultMapper
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getPlaybackState.GetPlaybackStateResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class PlaybackStateResponseToResultMapperImpl(
    private val playbackStateOutputToDataMapper: PlaybackStateOutputToDataMapper
) : PlaybackStateResponseToResultMapper {

    override fun map(item: CurrentlyPlayingContextObject): GetPlaybackStateResult {
        return if (item.item == null) {
            GetPlaybackStateResult.None
        } else {
            GetPlaybackStateResult.Value(
                playbackState = item.mapWith(playbackStateOutputToDataMapper)
            )
        }
    }
}
