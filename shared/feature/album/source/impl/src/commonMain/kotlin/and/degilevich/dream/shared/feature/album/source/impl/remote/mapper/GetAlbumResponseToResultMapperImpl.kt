package and.degilevich.dream.shared.feature.album.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getAlbum.GetAlbumResponse
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumData
import and.degilevich.dream.shared.feature.album.source.api.remote.mapper.AlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.source.api.remote.mapper.GetAlbumResponseToResultMapper
import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumResult
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class GetAlbumResponseToResultMapperImpl(
    private val albumOutputToDataMapper: AlbumOutputToDataMapper
) : GetAlbumResponseToResultMapper {
    override fun map(item: GetAlbumResponse): GetAlbumResult {
        return GetAlbumResult(
            album = item?.mapWith(albumOutputToDataMapper).orEmpty(AlbumData)
        )
    }
}