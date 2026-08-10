package and.degilevich.dream.shared.feature.search.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PagingArtistObject
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchArtistsOutputToDataMapper
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchArtistsData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeSearchArtistsOutputToDataMapper(
    private val onMap: (PagingArtistObject) -> SearchArtistsData = { fakeImplementationError() }
) : SearchArtistsOutputToDataMapper {

    override fun map(item: PagingArtistObject): SearchArtistsData = onMap(item)
}
