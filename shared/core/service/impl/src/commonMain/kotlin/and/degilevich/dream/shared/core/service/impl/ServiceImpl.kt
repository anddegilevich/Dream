package and.degilevich.dream.shared.core.service.impl

import and.degilevich.dream.shared.core.client.api.RemoteClient
import and.degilevich.dream.shared.core.client.api.ext.foldResponse
import and.degilevich.dream.shared.core.client.api.ext.safeGet
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

    override suspend fun getArtistTopTracks(request: GetArtistTopTracksRequest): Result<GetArtistTopTracksResponse> {
        return remoteClient.safeGet {
            url("artists/${request.id}/top-tracks")
        }.foldResponse()
    }

    override suspend fun getArtistRelatedArtists(
        request: GetArtistRelatedArtistsRequest
    ): Result<GetArtistRelatedArtistsResponse> {
        return remoteClient.safeGet {
            url("artists/${request.id}/related-artists")
        }.foldResponse()
    }

    override suspend fun getAlbum(request: GetAlbumRequest): Result<GetAlbumResponse> {
        return remoteClient.safeGet {
            url("albums/${request.id}")
        }.foldResponse()
    }

    override suspend fun getNewReleases(request: GetNewReleasesRequest): Result<GetNewReleasesResponse> {
        return remoteClient.safeGet {
            url("browse/new-releases")
            parameter("limit", request.limit)
            parameter("offset", request.offset)
        }.foldResponse()
    }

    override suspend fun getTrack(request: GetTrackRequest): Result<GetTrackResponse> {
        return remoteClient.safeGet {
            url("tracks/${request.id}")
        }.foldResponse()
    }

    override suspend fun getRecommendations(request: GetRecommendationsRequest): Result<GetRecommendationsResponse> {
        return remoteClient.safeGet {
            url("recommendations")
            parameter("limit", request.limit)
        }.foldResponse()
    }
}