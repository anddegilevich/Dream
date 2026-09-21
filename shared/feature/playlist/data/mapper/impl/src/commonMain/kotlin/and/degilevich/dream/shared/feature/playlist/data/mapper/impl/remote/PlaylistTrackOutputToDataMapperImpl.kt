package and.degilevich.dream.shared.feature.playlist.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PlaylistTrackObject
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote.PlaylistTrackOutputToDataMapper
import and.degilevich.dream.shared.feature.playlist.model.core.api.data.PlaylistTrackData
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class PlaylistTrackOutputToDataMapperImpl(
    private val trackOutputToDataMapper: TrackOutputToDataMapper
) : PlaylistTrackOutputToDataMapper {

    override fun map(item: PlaylistTrackObject): PlaylistTrackData = with(item) {
        PlaylistTrackData(
            track = this.item?.mapWith(trackOutputToDataMapper).orEmpty(TrackData),
            addedAt = addedAt.orEmpty()
        )
    }
}
