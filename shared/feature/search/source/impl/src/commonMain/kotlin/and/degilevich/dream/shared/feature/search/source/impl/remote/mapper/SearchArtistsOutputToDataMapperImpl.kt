package and.degilevich.dream.shared.feature.search.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.search.SearchArtistsOutput
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchArtistsData
import and.degilevich.dream.shared.feature.search.source.api.remote.mapper.SearchArtistsOutputToDataMapper
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