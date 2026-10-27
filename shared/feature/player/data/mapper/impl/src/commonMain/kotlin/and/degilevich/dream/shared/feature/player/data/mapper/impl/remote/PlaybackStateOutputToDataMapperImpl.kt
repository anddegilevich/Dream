package and.degilevich.dream.shared.feature.player.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.CurrentlyPlayingContextObject
import and.degilevich.dream.shared.feature.player.data.mapper.api.remote.PlaybackStateOutputToDataMapper
import and.degilevich.dream.shared.feature.player.domain.model.core.api.data.PlaybackStateData
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.domain.model.core.api.data.TrackData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.primitives.boolean.orFalse
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero

internal class PlaybackStateOutputToDataMapperImpl(
    private val trackOutputToDataMapper: TrackOutputToDataMapper
) : PlaybackStateOutputToDataMapper {

    override fun map(item: CurrentlyPlayingContextObject): PlaybackStateData = with(item) {
        PlaybackStateData(
            track = this.item?.mapWith(trackOutputToDataMapper).orEmpty(TrackData),
            isPlaying = isPlaying.orFalse(),
            progressMs = progressMs.orZero(),
            isShuffling = shuffleState.orFalse(),
            deviceName = device?.name.orEmpty()
        )
    }
}
