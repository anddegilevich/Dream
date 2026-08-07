package and.degilevich.dream.shared.feature.search.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.api.SearchApi
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchTypeToRequestMapper
import and.degilevich.dream.shared.feature.search.model.core.api.dictionary.SearchType
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeSearchTypeToRequestMapper(
    private val onMap: (SearchType) -> SearchApi.TypeSearch = { fakeImplementationError() }
) : SearchTypeToRequestMapper {

    override fun map(item: SearchType): SearchApi.TypeSearch = onMap(item)
}
