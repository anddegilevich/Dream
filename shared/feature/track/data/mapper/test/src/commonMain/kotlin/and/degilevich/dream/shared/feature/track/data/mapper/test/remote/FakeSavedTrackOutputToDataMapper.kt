package and.degilevich.dream.shared.feature.track.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.model.SavedTrackObject
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.SavedTrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.core.api.data.SavedTrackData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeSavedTrackOutputToDataMapper(
    private val onMap: (SavedTrackObject) -> SavedTrackData = { fakeImplementationError() }
) : SavedTrackOutputToDataMapper {

    override fun map(item: SavedTrackObject): SavedTrackData = onMap(item)
}
