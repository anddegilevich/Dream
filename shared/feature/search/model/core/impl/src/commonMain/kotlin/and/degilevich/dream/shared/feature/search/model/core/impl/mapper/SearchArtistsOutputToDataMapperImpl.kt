package and.degilevich.dream.shared.feature.search.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.model.method.search.SearchArtistsOutput
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.search.model.core.api.mapper.SearchArtistsOutputToDataMapper
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchArtistsData
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import kotlin.collections.orEmpty

internal class SearchArtistsOutputToDataMapperImpl(
    private val artistOutputToDataMapper: ArtistOutputToDataMapper,
) : SearchArtistsOutputToDataMapper {
    override fun map(item: SearchArtistsOutput): SearchArtistsData {
        return with(item) {
            SearchArtistsData(
                items = items?.mapWith(artistOutputToDataMapper).orEmpty()
            )
        }
    }
}