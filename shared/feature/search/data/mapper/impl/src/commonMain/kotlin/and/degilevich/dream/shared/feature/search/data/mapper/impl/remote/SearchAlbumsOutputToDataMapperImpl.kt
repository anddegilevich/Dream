package and.degilevich.dream.shared.feature.search.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.model.method.search.SearchAlbumsOutput
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.AlbumSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchAlbumsData
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchAlbumsOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class SearchAlbumsOutputToDataMapperImpl(
    private val albumSimplifiedOutputToDataMapper: AlbumSimplifiedOutputToDataMapper,
) : SearchAlbumsOutputToDataMapper {

    override fun map(item: SearchAlbumsOutput): SearchAlbumsData = with(item) {
        SearchAlbumsData(
            items = items?.mapWith(albumSimplifiedOutputToDataMapper).orEmpty()
        )
    }
}