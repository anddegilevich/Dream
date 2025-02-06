package and.degilevich.dream.shared.feature.artist.core.impl.source.remote.mappers

import and.degilevich.dream.shared.core.service.api.requests.getArtists.GetArtistsRequest
import and.degilevich.dream.shared.core.service.api.requests.getArtists.GetArtistsResponse
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsResult
import and.degilevich.dream.shared.feature.artist.model.core.mappers.mapToDomain
import and.degilevich.dream.shared.foundation.model.empty.state.ext.orEmpty

internal fun GetArtistsParams.mapToRequest(): GetArtistsRequest {
    return GetArtistsRequest(ids = ids)
}

internal fun GetArtistsResponse?.mapToResult(): GetArtistsResult {
    return this?.let {
        GetArtistsResult(
            artists = artists?.map { artist ->
                artist.mapToDomain()
            }.orEmpty()
        )
    }.orEmpty(GetArtistsResult)
}