package and.degilevich.dream.shared.feature.track.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PagingSavedTrackObject
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.SavedTracksResponseToResultMapper
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeSavedTracksResponseToResultMapper(
    private val onMap: (PagingSavedTrackObject) -> GetSavedTracksResult = { fakeImplementationError() }
) : SavedTracksResponseToResultMapper {

    override fun map(item: PagingSavedTrackObject): GetSavedTracksResult = onMap(item)
}
