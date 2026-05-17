package and.degilevich.dream.shared.feature.track.data.mapper.impl.local

import and.degilevich.dream.shared.core.db.api.entity.TrackEntity
import and.degilevich.dream.shared.feature.track.model.artifact.data.TrackSimplifiedData
import and.degilevich.dream.shared.feature.track.data.mapper.api.local.TrackSimplifiedDataToEntityMapper

internal class TrackSimplifiedDataToEntityMapperImpl : TrackSimplifiedDataToEntityMapper {

    override fun map(item: TrackSimplifiedData): TrackEntity = with(item) {
        TrackEntity(
            id = id.value,
            name = name,
            albumId = null,
            trackNumber = trackNumber,
            durationMs = durationMs
        )
    }
}