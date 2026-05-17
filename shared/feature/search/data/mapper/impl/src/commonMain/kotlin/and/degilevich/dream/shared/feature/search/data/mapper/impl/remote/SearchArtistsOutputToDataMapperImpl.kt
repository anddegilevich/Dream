package and.degilevich.dream.shared.feature.search.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.model.method.search.SearchArtistsOutput
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchArtistsData
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchArtistsOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class SearchArtistsOutputToDataMapperImpl(
    private val artistOutputToDataMapper: ArtistOutputToDataMapper,
) : SearchArtistsOutputToDataMapper {

    override fun map(item: SearchArtistsOutput): SearchArtistsData = with(item) {
        SearchArtistsData(
            items = items?.mapWith(artistOutputToDataMapper).orEmpty()
        )
    }
}