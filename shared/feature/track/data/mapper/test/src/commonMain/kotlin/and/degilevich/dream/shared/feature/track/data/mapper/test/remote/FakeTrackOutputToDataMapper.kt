package and.degilevich.dream.shared.feature.track.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.model.TrackObject
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeTrackOutputToDataMapper(
    private val onMap: (TrackObject) -> TrackData = { fakeImplementationError() }
) : TrackOutputToDataMapper {

    override fun map(item: TrackObject): TrackData = onMap(item)
}
