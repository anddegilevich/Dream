package and.degilevich.dream.shared.feature.search.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.api.SearchApi
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchTypeToRequestMapper
import and.degilevich.dream.shared.feature.search.model.core.api.dictionary.SearchType

internal class SearchTypeToRequestMapperImpl : SearchTypeToRequestMapper {

    override fun map(item: SearchType): SearchApi.TypeSearch {
        return when (item) {
            SearchType.ALBUM -> SearchApi.TypeSearch.ALBUM
            SearchType.ARTIST -> SearchApi.TypeSearch.ARTIST
            SearchType.PLAYLIST -> SearchApi.TypeSearch.PLAYLIST
            SearchType.TRACK -> SearchApi.TypeSearch.TRACK
            SearchType.SHOW -> SearchApi.TypeSearch.SHOW
            SearchType.EPISODE -> SearchApi.TypeSearch.EPISODE
            SearchType.AUDIOBOOK -> SearchApi.TypeSearch.AUDIOBOOK
        }
    }
}