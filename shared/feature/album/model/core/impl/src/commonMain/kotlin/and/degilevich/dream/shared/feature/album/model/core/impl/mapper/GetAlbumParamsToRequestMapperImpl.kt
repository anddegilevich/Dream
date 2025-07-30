package and.degilevich.dream.shared.feature.album.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getAlbum.GetAlbumRequest
import and.degilevich.dream.shared.feature.album.model.core.api.mapper.GetAlbumParamsToRequestMapper
import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumParams

internal class GetAlbumParamsToRequestMapperImpl : GetAlbumParamsToRequestMapper {
    override fun map(item: GetAlbumParams): GetAlbumRequest {
        return with(item) {
            GetAlbumRequest(
                id = id
            )
        }
    }
}