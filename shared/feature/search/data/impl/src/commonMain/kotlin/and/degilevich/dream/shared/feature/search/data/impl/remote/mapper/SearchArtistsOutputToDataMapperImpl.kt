package and.degilevich.dream.shared.feature.search.data.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.search.SearchArtistsOutput
import and.degilevich.dream.shared.feature.artist.data.api.remote.mapper.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchArtistsData
import and.degilevich.dream.shared.feature.search.data.api.remote.mapper.SearchArtistsOutputToDataMapper
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