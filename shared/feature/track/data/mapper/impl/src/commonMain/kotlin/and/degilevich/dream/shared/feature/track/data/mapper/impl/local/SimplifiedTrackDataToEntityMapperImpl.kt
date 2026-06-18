package and.degilevich.dream.shared.feature.track.data.mapper.impl.local

import and.degilevich.dream.shared.core.db.api.entity.TrackEntity
import and.degilevich.dream.shared.feature.track.data.mapper.api.local.SimplifiedTrackDataToEntityMapper
import and.degilevich.dream.shared.feature.track.model.artifact.data.SimplifiedTrackData

internal class SimplifiedTrackDataToEntityMapperImpl : SimplifiedTrackDataToEntityMapper {

    override fun map(item: SimplifiedTrackData): TrackEntity = with(item) {
        TrackEntity(
            id = id.value,
            name = name,
            albumId = null,
            trackNumber = trackNumber,
            durationMs = durationMs
        )
    }
}