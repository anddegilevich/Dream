package and.degilevich.dream.shared.feature.player.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PlayHistoryObject
import and.degilevich.dream.shared.feature.player.data.mapper.api.remote.PlayHistoryOutputToDataMapper
import and.degilevich.dream.shared.feature.player.model.core.api.data.PlayHistoryData
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class PlayHistoryOutputToDataMapperImpl(
    private val trackOutputToDataMapper: TrackOutputToDataMapper
) : PlayHistoryOutputToDataMapper {

    override fun map(item: PlayHistoryObject): PlayHistoryData = with(item) {
        PlayHistoryData(
            track = track?.mapWith(trackOutputToDataMapper).orEmpty(TrackData),
            playedAt = playedAt.orEmpty()
        )
    }
}
