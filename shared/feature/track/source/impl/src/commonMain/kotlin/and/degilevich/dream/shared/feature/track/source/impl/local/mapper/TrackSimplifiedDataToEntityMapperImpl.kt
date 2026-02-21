package and.degilevich.dream.shared.feature.track.source.impl.local.mapper

import and.degilevich.dream.shared.core.db.api.entity.TrackEntity
import and.degilevich.dream.shared.feature.track.model.artifact.api.data.TrackSimplifiedData
import and.degilevich.dream.shared.feature.track.source.api.local.mapper.TrackSimplifiedDataToEntityMapper

internal class TrackSimplifiedDataToEntityMapperImpl : TrackSimplifiedDataToEntityMapper {

    override fun map(item: TrackSimplifiedData): TrackEntity = with(item) {
        TrackEntity(
            id = id.id,
            name = name,
            albumId = null,
            trackNumber = trackNumber,
            durationMs = durationMs
        )
    }
}