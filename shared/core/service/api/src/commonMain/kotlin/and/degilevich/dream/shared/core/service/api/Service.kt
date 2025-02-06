package and.degilevich.dream.shared.core.service.api

import and.degilevich.dream.shared.core.service.api.requests.getArtists.GetArtistsRequest
import and.degilevich.dream.shared.core.service.api.requests.getArtists.GetArtistsResponse

interface Service {
    suspend fun getArtists(request: GetArtistsRequest): GetArtistsResponse
}