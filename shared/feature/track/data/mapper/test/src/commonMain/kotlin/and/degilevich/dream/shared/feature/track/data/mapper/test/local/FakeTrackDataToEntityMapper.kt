package and.degilevich.dream.shared.feature.track.data.mapper.test.local

import and.degilevich.dream.shared.core.db.api.entity.TrackEntity
import and.degilevich.dream.shared.feature.track.data.mapper.api.local.TrackDataToEntityMapper
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeTrackDataToEntityMapper(
    private val onMap: (TrackData) -> TrackEntity = { fakeImplementationError() }
) : TrackDataToEntityMapper {

    override fun map(item: TrackData): TrackEntity = onMap(item)
}
