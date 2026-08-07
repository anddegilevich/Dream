package and.degilevich.dream.shared.feature.search.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PagingSimplifiedAlbumObject
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchAlbumsOutputToDataMapper
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchAlbumsData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeSearchAlbumsOutputToDataMapper(
    private val onMap: (PagingSimplifiedAlbumObject) -> SearchAlbumsData = { fakeImplementationError() }
) : SearchAlbumsOutputToDataMapper {

    override fun map(item: PagingSimplifiedAlbumObject): SearchAlbumsData = onMap(item)
}
