package and.degilevich.dream.shared.feature.album.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.requests.getAlbum.GetAlbumRequest
import and.degilevich.dream.shared.feature.album.model.core.api.mapper.GetAlbumParamsToRequestMapper
import and.degilevich.dream.shared.feature.album.model.core.api.request.getAlbum.GetAlbumParams

internal class GetAlbumParamsToRequestMapperImpl : GetAlbumParamsToRequestMapper {
    override fun map(item: GetAlbumParams): GetAlbumRequest {
        return with(item) {
            GetAlbumRequest(
                id = id
            )
        }
    }
}