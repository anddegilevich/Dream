package and.degilevich.dream.shared.feature.search.domain.api.paging

import and.degilevich.dream.shared.feature.base.domain.api.paging.PagingSource
import and.degilevich.dream.shared.feature.search.model.core.api.data.SearchItemData

interface SearchPagingSource : PagingSource<SearchItemData> {

    fun setQuery(query: String)
}
