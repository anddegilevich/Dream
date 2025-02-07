package and.degilevich.dream.shared.core.service.api

import and.degilevich.dream.shared.core.service.api.requests.getArtist.GetArtistRequest
import and.degilevich.dream.shared.core.service.api.requests.getArtist.GetArtistResponse
import and.degilevich.dream.shared.core.service.api.requests.getArtists.GetArtistsRequest
import and.degilevich.dream.shared.core.service.api.requests.getArtists.GetArtistsResponse

interface Service {
    suspend fun getArtists(request: GetArtistsRequest): Result<GetArtistsResponse>
    suspend fun getArtist(request: GetArtistRequest): Result<GetArtistResponse>
}