package and.degilevich.dream.shared.feature.search.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.model.Search200Response
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchResponseToResultMapper
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeSearchResponseToResultMapper(
    private val onMap: (Search200Response) -> SearchResult = { fakeImplementationError() }
) : SearchResponseToResultMapper {

    override fun map(item: Search200Response): SearchResult = onMap(item)
}
