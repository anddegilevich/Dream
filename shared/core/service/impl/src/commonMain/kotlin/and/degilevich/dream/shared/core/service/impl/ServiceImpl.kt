package and.degilevich.dream.shared.core.service.impl

import and.degilevich.dream.shared.core.client.api.RemoteClient
import and.degilevich.dream.shared.core.client.api.ext.foldBody
import and.degilevich.dream.shared.core.service.api.Service
import and.degilevich.dream.shared.core.service.api.model.method.getAlbum.GetAlbumRequest
import and.degilevich.dream.shared.core.service.api.model.method.getAlbum.GetAlbumResponse
import and.degilevich.dream.shared.core.service.api.model.method.getArtist.GetArtistRequest
import and.degilevich.dream.shared.core.service.api.model.method.getArtist.GetArtistResponse
import and.degilevich.dream.shared.core.service.api.model.method.getArtistAlbums.GetArtistAlbumsRequest
import and.degilevich.dream.shared.core.service.api.model.method.getArtistAlbums.GetArtistAlbumsResponse
import and.degilevich.dream.shared.core.service.api.model.method.getTrack.GetTrackRequest
import and.degilevich.dream.shared.core.service.api.model.method.getTrack.GetTrackResponse
import and.degilevich.dream.shared.core.service.api.model.method.search.SearchRequest
import and.degilevich.dream.shared.core.service.api.model.method.search.SearchResponse
import io.ktor.client.request.parameter
import io.ktor.client.request.url

internal class ServiceImpl(
    private val remoteClient: RemoteClient
) : Service {

    override suspend fun getArtist(request: GetArtistRequest): Result<GetArtistResponse> {
        return remoteClient.getCatching {
            url("artists/${request.id}")
        }.foldBody()
    }

    override suspend fun getArtistAlbums(request: GetArtistAlbumsRequest): Result<GetArtistAlbumsResponse> {
        return remoteClient.getCatching {
            url("artists/${request.id}/albums")
            parameter("limit", request.limit)
            parameter("offset", request.offset)
        }.foldBody()
    }

    override suspend fun getAlbum(request: GetAlbumRequest): Result<GetAlbumResponse> {
        return remoteClient.getCatching {
            url("albums/${request.id}")
        }.foldBody()
    }

    override suspend fun getTrack(request: GetTrackRequest): Result<GetTrackResponse> {
        return remoteClient.getCatching {
            url("tracks/${request.id}")
        }.foldBody()
    }

    override suspend fun search(request: SearchRequest): Result<SearchResponse> {
        return remoteClient.getCatching {
            url("search")
            parameter("q", request.q)
            parameter("limit", request.limit)
            parameter("offset", request.offset)
            parameter("type", request.type?.joinToString(","))
        }.foldBody()
    }
}