package and.degilevich.dream.shared.core.service.impl

import and.degilevich.dream.shared.core.client.api.RemoteClient
import and.degilevich.dream.shared.core.service.api.Service
import and.degilevich.dream.shared.core.service.api.requests.getArtists.GetArtistsRequest
import and.degilevich.dream.shared.core.service.api.requests.getArtists.GetArtistsResponse
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url

internal class ServiceImpl(
    private val remoteClient: RemoteClient
) : Service {
    override suspend fun getArtists(request: GetArtistsRequest): GetArtistsResponse {
        return remoteClient.client.get {
            url("artists")
            parameter("ids", request.ids.joinToString(separator = ","))
        }.body<GetArtistsResponse>()
    }
}