package and.degilevich.dream.shared.feature.search.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PagingTrackObject
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchTracksData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeSearchTracksOutputToDataMapper(
    private val onMap: (PagingTrackObject) -> SearchTracksData = { fakeImplementationError() }
) : SearchTracksOutputToDataMapper {

    override fun map(item: PagingTrackObject): SearchTracksData = onMap(item)
}
