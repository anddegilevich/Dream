package and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getArtist.GetArtistRequest
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.GetArtistParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtist.GetArtistParams

internal class GetArtistParamsToRequestMapperImpl : GetArtistParamsToRequestMapper {
    override fun map(item: GetArtistParams): GetArtistRequest {
        return with(item) {
            GetArtistRequest(
                id = id
            )
        }
    }
}