package and.degilevich.dream.shared.feature.track.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedTrackObject
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.SimplifiedTrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.artifact.api.data.SimplifiedTrackData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeSimplifiedTrackOutputToDataMapper(
    private val onMap: (SimplifiedTrackObject) -> SimplifiedTrackData = { fakeImplementationError() }
) : SimplifiedTrackOutputToDataMapper {

    override fun map(item: SimplifiedTrackObject): SimplifiedTrackData = onMap(item)
}
