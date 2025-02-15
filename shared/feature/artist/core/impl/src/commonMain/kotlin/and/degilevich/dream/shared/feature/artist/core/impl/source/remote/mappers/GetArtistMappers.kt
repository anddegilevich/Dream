package and.degilevich.dream.shared.feature.artist.core.impl.source.remote.mappers

import and.degilevich.dream.shared.core.service.api.requests.getArtist.GetArtistRequest
import and.degilevich.dream.shared.core.service.api.requests.getArtist.GetArtistResponse
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.model.core.mappers.mapToData

internal fun GetArtistParams.mapToRequest(): GetArtistRequest {
    return GetArtistRequest(
        id = id
    )
}
internal fun GetArtistResponse.mapToResult(): GetArtistResult {
    return GetArtistResult(
        artist = mapToData()
    )
}