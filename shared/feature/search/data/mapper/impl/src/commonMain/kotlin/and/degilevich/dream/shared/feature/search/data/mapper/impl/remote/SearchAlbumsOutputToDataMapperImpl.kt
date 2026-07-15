package and.degilevich.dream.shared.feature.search.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PagingSimplifiedAlbumObject
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.SimplifiedAlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchAlbumsOutputToDataMapper
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchAlbumsData
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class SearchAlbumsOutputToDataMapperImpl(
    private val simplifiedAlbumOutputToDataMapper: SimplifiedAlbumOutputToDataMapper,
) : SearchAlbumsOutputToDataMapper {

    override fun map(item: PagingSimplifiedAlbumObject): SearchAlbumsData = with(item) {
        SearchAlbumsData(
            items = items.mapWith(simplifiedAlbumOutputToDataMapper)
        )
    }
}