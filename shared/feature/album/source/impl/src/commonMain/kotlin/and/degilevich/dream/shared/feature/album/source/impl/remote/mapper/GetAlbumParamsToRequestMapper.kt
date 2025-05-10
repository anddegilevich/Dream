package and.degilevich.dream.shared.feature.album.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.requests.getAlbum.GetAlbumRequest
import and.degilevich.dream.shared.feature.album.source.api.remote.request.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

internal class GetAlbumParamsToRequestMapper : Mapper<GetAlbumParams, GetAlbumRequest> {
    override fun map(item: GetAlbumParams): GetAlbumRequest {
        return with(item) {
            GetAlbumRequest(
                id = id
            )
        }
    }
}