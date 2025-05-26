package and.degilevich.dream.shared.core.service.impl

import and.degilevich.dream.shared.core.client.api.RemoteClient
import and.degilevich.dream.shared.core.client.api.ext.foldBody
import and.degilevich.dream.shared.core.service.api.Service
import and.degilevich.dream.shared.core.service.api.requests.getAlbum.GetAlbumRequest
import and.degilevich.dream.shared.core.service.api.requests.getAlbum.GetAlbumResponse
import and.degilevich.dream.shared.core.service.api.requests.getArtist.GetArtistRequest
import and.degilevich.dream.shared.core.service.api.requests.getArtist.GetArtistResponse
import and.degilevich.dream.shared.core.service.api.requests.getArtistRelatedArtists.GetArtistRelatedArtistsRequest
import and.degilevich.dream.shared.core.service.api.requests.getArtistRelatedArtists.GetArtistRelatedArtistsResponse
import and.degilevich.dream.shared.core.service.api.requests.getArtistTopTracks.GetArtistTopTracksRequest
import and.degilevich.dream.shared.core.service.api.requests.getArtistTopTracks.GetArtistTopTracksResponse
import and.degilevich.dream.shared.core.service.api.requests.getArtists.GetArtistsRequest
import and.degilevich.dream.shared.core.service.api.requests.getArtists.GetArtistsResponse
import and.degilevich.dream.shared.core.service.api.requests.getNewReleases.GetNewReleasesRequest
import and.degilevich.dream.shared.core.service.api.requests.getNewReleases.GetNewReleasesResponse
import and.degilevich.dream.shared.core.service.api.requests.getRecommendations.GetRecommendationsRequest
import and.degilevich.dream.shared.core.service.api.requests.getRecommendations.GetRecommendationsResponse
import and.degilevich.dream.shared.core.service.api.requests.getTrack.GetTrackRequest
import and.degilevich.dream.shared.core.service.api.requests.getTrack.GetTrackResponse
import and.degilevich.dream.shared.core.service.api.requests.search.SearchRequest
import and.degilevich.dream.shared.core.service.api.requests.search.SearchResponse
import io.ktor.client.request.parameter
import io.ktor.client.request.url

internal class ServiceImpl(
    private val remoteClient: RemoteClient
) : Service {
    override suspend fun getArtists(request: GetArtistsRequest): Result<GetArtistsResponse> {
        return remoteClient.getCatching {
            url("artists")
            parameter("ids", request.ids)
        }.foldBody()
    }

    override suspend fun getArtist(request: GetArtistRequest): Result<GetArtistResponse> {
        return remoteClient.getCatching {
            url("artists/${request.id}")
        }.foldBody()
    }

    override suspend fun getArtistTopTracks(request: GetArtistTopTracksRequest): Result<GetArtistTopTracksResponse> {
        return remoteClient.getCatching {
            url("artists/${request.id}/top-tracks")
        }.foldBody()
    }

    override suspend fun getArtistRelatedArtists(
        request: GetArtistRelatedArtistsRequest
    ): Result<GetArtistRelatedArtistsResponse> {
        return remoteClient.getCatching {
            url("artists/${request.id}/related-artists")
        }.foldBody()
    }

    override suspend fun getAlbum(request: GetAlbumRequest): Result<GetAlbumResponse> {
        return remoteClient.getCatching {
            url("albums/${request.id}")
        }.foldBody()
    }

    override suspend fun getNewReleases(request: GetNewReleasesRequest): Result<GetNewReleasesResponse> {
        return remoteClient.getCatching {
            url("browse/new-releases")
            parameter("limit", request.limit)
            parameter("offset", request.offset)
        }.foldBody()
    }

    override suspend fun getTrack(request: GetTrackRequest): Result<GetTrackResponse> {
        return remoteClient.getCatching {
            url("tracks/${request.id}")
        }.foldBody()
    }

    override suspend fun getRecommendations(request: GetRecommendationsRequest): Result<GetRecommendationsResponse> {
        return remoteClient.getCatching {
            url("recommendations")
            parameter("limit", request.limit)
        }.foldBody()
    }

    override suspend fun search(request: SearchRequest): Result<SearchResponse> {
        return remoteClient.getCatching {
            url("search")
            parameter("q", request.q)
            parameter("limit", request.limit)
            parameter("offset", request.offset)
            parameter("type", request.type)
        }.foldBody()
    }
}