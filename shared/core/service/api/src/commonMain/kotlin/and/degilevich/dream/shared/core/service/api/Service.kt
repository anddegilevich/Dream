package and.degilevich.dream.shared.core.service.api

import and.degilevich.dream.shared.core.service.api.requests.getAlbum.GetAlbumRequest
import and.degilevich.dream.shared.core.service.api.requests.getAlbum.GetAlbumResponse
import and.degilevich.dream.shared.core.service.api.requests.getArtist.GetArtistRequest
import and.degilevich.dream.shared.core.service.api.requests.getArtist.GetArtistResponse
import and.degilevich.dream.shared.core.service.api.requests.getArtistAlbums.GetArtistAlbumsRequest
import and.degilevich.dream.shared.core.service.api.requests.getArtistAlbums.GetArtistAlbumsResponse
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

interface Service {
    // Artist
    suspend fun getArtists(request: GetArtistsRequest): Result<GetArtistsResponse>
    suspend fun getArtist(request: GetArtistRequest): Result<GetArtistResponse>
    suspend fun getArtistTopTracks(request: GetArtistTopTracksRequest): Result<GetArtistTopTracksResponse>
    suspend fun getArtistAlbums(request: GetArtistAlbumsRequest): Result<GetArtistAlbumsResponse>
    suspend fun getArtistRelatedArtists(
        request: GetArtistRelatedArtistsRequest
    ): Result<GetArtistRelatedArtistsResponse>

    // Album
    suspend fun getAlbum(request: GetAlbumRequest): Result<GetAlbumResponse>
    suspend fun getNewReleases(request: GetNewReleasesRequest): Result<GetNewReleasesResponse>

    // Track
    suspend fun getTrack(request: GetTrackRequest): Result<GetTrackResponse>
    suspend fun getRecommendations(request: GetRecommendationsRequest): Result<GetRecommendationsResponse>

    // Search
    suspend fun search(request: SearchRequest): Result<SearchResponse>
}