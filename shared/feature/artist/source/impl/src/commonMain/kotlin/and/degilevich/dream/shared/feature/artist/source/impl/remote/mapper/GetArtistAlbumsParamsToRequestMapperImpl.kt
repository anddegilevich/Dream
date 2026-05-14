package and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getArtistAlbums.GetArtistAlbumsRequest
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtistAlbums.GetArtistAlbumsParams
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.GetArtistAlbumsParamsToRequestMapper

internal class GetArtistAlbumsParamsToRequestMapperImpl : GetArtistAlbumsParamsToRequestMapper {

    override fun map(item: GetArtistAlbumsParams): GetArtistAlbumsRequest = with(item) {
        GetArtistAlbumsRequest(
            id = id.value,
            limit = limit,
            offset = offset
        )
    }
}