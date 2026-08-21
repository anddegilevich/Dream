package and.degilevich.dream.shared.feature.track.data.mapper.test.local

import and.degilevich.dream.shared.core.db.api.entity.TrackEntity
import and.degilevich.dream.shared.feature.track.data.mapper.api.local.SimplifiedTrackDataToEntityMapper
import and.degilevich.dream.shared.feature.track.model.artifact.api.data.SimplifiedTrackData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeSimplifiedTrackDataToEntityMapper(
    private val onMap: (SimplifiedTrackData) -> TrackEntity = { fakeImplementationError() }
) : SimplifiedTrackDataToEntityMapper {

    override fun map(item: SimplifiedTrackData): TrackEntity = onMap(item)
}