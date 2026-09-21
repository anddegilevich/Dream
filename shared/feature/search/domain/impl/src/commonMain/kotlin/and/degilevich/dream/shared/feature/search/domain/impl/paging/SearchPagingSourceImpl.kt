package and.degilevich.dream.shared.feature.search.domain.impl.paging

import and.degilevich.dream.shared.feature.base.domain.api.paging.model.PageData
import and.degilevich.dream.shared.feature.base.domain.impl.paging.BasePagingSource
import and.degilevich.dream.shared.feature.search.domain.api.paging.SearchPagingSource
import and.degilevich.dream.shared.feature.search.domain.api.usecase.SearchUseCase
import and.degilevich.dream.shared.feature.search.model.core.api.data.SearchItemData
import and.degilevich.dream.shared.feature.search.model.core.api.dictionary.SearchType
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchResult
import and.degilevich.dream.shared.foundation.primitive.collections.list.interleave
import com.arkivanov.decompose.ComponentContext

internal class SearchPagingSourceImpl(
    componentContext: ComponentContext,
    private val searchUseCase: SearchUseCase
) : BasePagingSource<SearchItemData>(
    componentContext = componentContext,
    pageSize = PAGE_SIZE,
    itemSerializer = SearchItemData.serializer()
),
    SearchPagingSource {

    private var query: String = ""

    override fun setQuery(query: String) {
        if (this.query == query) return
        this.query = query
        reset()
    }

    override suspend fun loadPage(
        limit: Int,
        offset: Int
    ): Result<PageData<SearchItemData>> {
        if (query.isEmpty()) return Result.success(PageData(items = emptyList(), total = 0))
        val params = SearchParams(
            query = query,
            limit = limit,
            offset = offset,
            types = SEARCH_TYPES
        )
        return searchUseCase(params).map(::mapResultToPage)
    }

    private fun mapResultToPage(result: SearchResult): PageData<SearchItemData> = with(result) {
        PageData(
            items = listOf(
                artists.items.map(SearchItemData::Artist),
                tracks.items.map(SearchItemData::Track),
                albums.items.map(SearchItemData::Album)
            ).interleave(),
            total = maxOf(
                tracks.total,
                artists.total,
                albums.total
            )
        )
    }

    internal companion object {
        const val PAGE_SIZE = 10
        val SEARCH_TYPES = listOf(
            SearchType.ALBUM,
            SearchType.ARTIST,
            SearchType.TRACK
        )
    }
}
