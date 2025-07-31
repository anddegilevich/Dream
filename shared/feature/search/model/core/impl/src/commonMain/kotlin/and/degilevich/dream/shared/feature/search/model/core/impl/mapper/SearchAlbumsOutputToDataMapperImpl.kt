package and.degilevich.dream.shared.feature.search.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.model.method.search.SearchAlbumsOutput
import and.degilevich.dream.shared.feature.album.model.artifact.api.mapper.AlbumSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.search.model.core.api.mapper.SearchAlbumsOutputToDataMapper
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchAlbumsData
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class SearchAlbumsOutputToDataMapperImpl(
    private val albumSimplifiedOutputToDataMapper: AlbumSimplifiedOutputToDataMapper,
) : SearchAlbumsOutputToDataMapper {
    override fun map(item: SearchAlbumsOutput): SearchAlbumsData {
        return with(item) {
            SearchAlbumsData(
                items = items?.mapWith(albumSimplifiedOutputToDataMapper).orEmpty()
            )
        }
    }
}