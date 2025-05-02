package and.degilevich.dream.shared.feature.artist.core.impl.source.remote.mappers

import and.degilevich.dream.shared.core.service.api.requests.getArtist.GetArtistRequest
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtist.GetArtistParams
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

internal class GetArtistParamsToRequestMapper : Mapper<GetArtistParams, GetArtistRequest> {
    override fun map(item: GetArtistParams): GetArtistRequest {
        return with(item) {
            GetArtistRequest(
                id = id
            )
        }
    }
}