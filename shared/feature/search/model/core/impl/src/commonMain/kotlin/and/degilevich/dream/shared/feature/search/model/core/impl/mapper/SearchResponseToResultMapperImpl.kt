package and.degilevich.dream.shared.feature.search.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.model.method.search.SearchResponse
import and.degilevich.dream.shared.feature.search.model.core.api.mapper.SearchAlbumsOutputToDataMapper
import and.degilevich.dream.shared.feature.search.model.core.api.mapper.SearchArtistsOutputToDataMapper
import and.degilevich.dream.shared.feature.search.model.core.api.mapper.SearchResponseToResultMapper
import and.degilevich.dream.shared.feature.search.model.core.api.mapper.SearchTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchAlbumsData
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchArtistsData
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchResult
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchTracksData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class SearchResponseToResultMapperImpl(
    private val searchTracksOutputToDataMapper: SearchTracksOutputToDataMapper,
    private val searchArtistsOutputToDataMapper: SearchArtistsOutputToDataMapper,
    private val searchAlbumsOutputToDataMapper: SearchAlbumsOutputToDataMapper,
) : SearchResponseToResultMapper {
    override fun map(item: SearchResponse): SearchResult {
        return with(item) {
            SearchResult(
                tracks = tracks?.mapWith(searchTracksOutputToDataMapper).orEmpty(SearchTracksData),
                artists = artists?.mapWith(searchArtistsOutputToDataMapper).orEmpty(SearchArtistsData),
                albums = albums?.mapWith(searchAlbumsOutputToDataMapper).orEmpty(SearchAlbumsData)
            )
        }
    }
}