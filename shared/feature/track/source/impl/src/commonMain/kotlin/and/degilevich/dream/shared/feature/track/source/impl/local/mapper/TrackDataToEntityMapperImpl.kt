package and.degilevich.dream.shared.feature.track.source.impl.local.mapper

import and.degilevich.dream.shared.core.db.api.entity.TrackEntity
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.source.api.local.mapper.TrackDataToEntityMapper

internal class TrackDataToEntityMapperImpl : TrackDataToEntityMapper {

    override fun map(item: TrackData): TrackEntity = with(item) {
        TrackEntity(
            id = id.id,
            name = name,
            albumId = album.id.id,
            trackNumber = trackNumber,
            durationMs = durationMs
        )
    }
}