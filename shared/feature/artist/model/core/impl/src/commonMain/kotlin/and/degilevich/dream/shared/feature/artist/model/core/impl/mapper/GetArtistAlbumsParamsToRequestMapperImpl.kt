package and.degilevich.dream.shared.feature.artist.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getArtistAlbums.GetArtistAlbumsRequest
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistAlbumsParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistAlbums.GetArtistAlbumsParams

internal class GetArtistAlbumsParamsToRequestMapperImpl : GetArtistAlbumsParamsToRequestMapper {
    override fun map(item: GetArtistAlbumsParams): GetArtistAlbumsRequest {
        return with(item) {
            GetArtistAlbumsRequest(
                id = id,
                limit = limit,
                offset = offset
            )
        }
    }
}