package and.degilevich.dream.shared.core.service.impl

import and.degilevich.dream.shared.core.client.api.RemoteClient
import and.degilevich.dream.shared.core.client.api.ext.foldResponse
import and.degilevich.dream.shared.core.client.api.ext.safeGet
import and.degilevich.dream.shared.core.service.api.Service
import and.degilevich.dream.shared.core.service.api.requests.getArtist.GetArtistRequest
import and.degilevich.dream.shared.core.service.api.requests.getArtist.GetArtistResponse
import and.degilevich.dream.shared.core.service.api.requests.getArtists.GetArtistsRequest
import and.degilevich.dream.shared.core.service.api.requests.getArtists.GetArtistsResponse
import io.ktor.client.request.parameter
import io.ktor.client.request.url

internal class ServiceImpl(
    private val remoteClient: RemoteClient
) : Service {
    override suspend fun getArtists(request: GetArtistsRequest): Result<GetArtistsResponse> {
        return remoteClient.safeGet {
            url("artists")
            parameter("ids", request.ids)
        }.foldResponse()
    }

    override suspend fun getArtist(request: GetArtistRequest): Result<GetArtistResponse> {
        return remoteClient.safeGet {
            url("artists/${request.id}")
        }.foldResponse()
    }
}