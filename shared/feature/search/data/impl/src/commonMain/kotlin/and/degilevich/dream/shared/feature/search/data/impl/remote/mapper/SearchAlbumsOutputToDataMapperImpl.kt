package and.degilevich.dream.shared.feature.search.data.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.search.SearchAlbumsOutput
import and.degilevich.dream.shared.feature.album.data.api.remote.mapper.AlbumSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchAlbumsData
import and.degilevich.dream.shared.feature.search.data.api.remote.mapper.SearchAlbumsOutputToDataMapper
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