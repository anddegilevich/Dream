package and.degilevich.dream.shared.feature.search.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.Search200Response
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchAlbumsOutputToDataMapper
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchArtistsOutputToDataMapper
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchResponseToResultMapper
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchAlbumsData
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchArtistsData
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchResult
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchTracksData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class SearchResponseToResultMapperImpl(
    private val searchTracksOutputToDataMapper: SearchTracksOutputToDataMapper,
    private val searchArtistsOutputToDataMapper: SearchArtistsOutputToDataMapper,
    private val searchAlbumsOutputToDataMapper: SearchAlbumsOutputToDataMapper,
) : SearchResponseToResultMapper {

    override fun map(item: Search200Response): SearchResult = with(item) {
        SearchResult(
            tracks = tracks?.mapWith(searchTracksOutputToDataMapper).orEmpty(SearchTracksData),
            artists = artists?.mapWith(searchArtistsOutputToDataMapper).orEmpty(SearchArtistsData),
            albums = albums?.mapWith(searchAlbumsOutputToDataMapper).orEmpty(SearchAlbumsData)
        )
    }
}