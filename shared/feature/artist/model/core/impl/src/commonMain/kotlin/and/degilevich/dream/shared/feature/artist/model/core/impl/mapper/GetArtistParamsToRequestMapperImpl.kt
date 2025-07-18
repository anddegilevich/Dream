package and.degilevich.dream.shared.feature.artist.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.requests.getArtist.GetArtistRequest
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtist.GetArtistParams

internal class GetArtistParamsToRequestMapperImpl : GetArtistParamsToRequestMapper {
    override fun map(item: GetArtistParams): GetArtistRequest {
        return with(item) {
            GetArtistRequest(
                id = id
            )
        }
    }
}