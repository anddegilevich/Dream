package and.degilevich.dream.shared.feature.album.data.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getAlbum.GetAlbumRequest
import and.degilevich.dream.shared.feature.album.model.core.method.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.feature.album.data.api.remote.mapper.GetAlbumParamsToRequestMapper

internal class GetAlbumParamsToRequestMapperImpl : GetAlbumParamsToRequestMapper {

    override fun map(item: GetAlbumParams): GetAlbumRequest = with(item) {
        GetAlbumRequest(
            id = id.value
        )
    }
}