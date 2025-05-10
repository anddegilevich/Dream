package and.degilevich.dream.shared.feature.album.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.requests.getAlbum.GetAlbumResponse
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumData
import and.degilevich.dream.shared.feature.album.model.artifact.api.mapper.AlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.source.api.remote.request.getAlbum.GetAlbumResult
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class GetAlbumResponseToResultMapper(
    private val albumOutputToDataMapper: AlbumOutputToDataMapper
) : Mapper<GetAlbumResponse, GetAlbumResult> {
    override fun map(item: GetAlbumResponse): GetAlbumResult {
        return GetAlbumResult(
            album = item?.mapWith(albumOutputToDataMapper).orEmpty(AlbumData)
        )
    }
}