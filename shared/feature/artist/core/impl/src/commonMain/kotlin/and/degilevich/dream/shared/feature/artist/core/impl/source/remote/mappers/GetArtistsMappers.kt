package and.degilevich.dream.shared.feature.artist.core.impl.source.remote.mappers

import and.degilevich.dream.shared.core.service.api.requests.getArtists.GetArtistsRequest
import and.degilevich.dream.shared.core.service.api.requests.getArtists.GetArtistsResponse
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsResult
import and.degilevich.dream.shared.feature.artist.model.core.mappers.mapToData

internal fun GetArtistsParams.mapToRequest(): GetArtistsRequest {
    return GetArtistsRequest(
        ids = ids.joinToString(separator = ",")
    )
}

internal fun GetArtistsResponse.mapToResult(): GetArtistsResult {
    return GetArtistsResult(
        artists = artists?.map { artist ->
            artist.mapToData()
        }.orEmpty()
    )
}