package and.degilevich.dream.shared.feature.artist.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.model.method.getArtist.GetArtistRequest
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.GetArtistParamsToRequestMapper

internal class GetArtistParamsToRequestMapperImpl : GetArtistParamsToRequestMapper {

    override fun map(item: GetArtistParams): GetArtistRequest = with(item) {
        GetArtistRequest(
            id = id.value
        )
    }
}