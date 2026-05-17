package and.degilevich.dream.shared.feature.artist.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.model.method.getArtistAlbums.GetArtistAlbumsRequest
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtistAlbums.GetArtistAlbumsParams
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.GetArtistAlbumsParamsToRequestMapper

internal class GetArtistAlbumsParamsToRequestMapperImpl : GetArtistAlbumsParamsToRequestMapper {

    override fun map(item: GetArtistAlbumsParams): GetArtistAlbumsRequest = with(item) {
        GetArtistAlbumsRequest(
            id = id.value,
            limit = limit,
            offset = offset
        )
    }
}