package and.degilevich.dream.shared.core.service.api

import and.degilevich.dream.shared.core.service.api.model.method.getAlbum.GetAlbumRequest
import and.degilevich.dream.shared.core.service.api.model.method.getAlbum.GetAlbumResponse
import and.degilevich.dream.shared.core.service.api.model.method.getArtist.GetArtistRequest
import and.degilevich.dream.shared.core.service.api.model.method.getArtist.GetArtistResponse
import and.degilevich.dream.shared.core.service.api.model.method.getArtistAlbums.GetArtistAlbumsRequest
import and.degilevich.dream.shared.core.service.api.model.method.getArtistAlbums.GetArtistAlbumsResponse
import and.degilevich.dream.shared.core.service.api.model.method.getArtistRelatedArtists.GetArtistRelatedArtistsRequest
import and.degilevich.dream.shared.core.service.api.model.method.getArtistRelatedArtists.GetArtistRelatedArtistsResponse
import and.degilevich.dream.shared.core.service.api.model.method.getArtistTopTracks.GetArtistTopTracksRequest
import and.degilevich.dream.shared.core.service.api.model.method.getArtistTopTracks.GetArtistTopTracksResponse
import and.degilevich.dream.shared.core.service.api.model.method.getArtists.GetArtistsRequest
import and.degilevich.dream.shared.core.service.api.model.method.getArtists.GetArtistsResponse
import and.degilevich.dream.shared.core.service.api.model.method.getNewReleases.GetNewReleasesRequest
import and.degilevich.dream.shared.core.service.api.model.method.getNewReleases.GetNewReleasesResponse
import and.degilevich.dream.shared.core.service.api.model.method.getRecommendations.GetRecommendationsRequest
import and.degilevich.dream.shared.core.service.api.model.method.getRecommendations.GetRecommendationsResponse
import and.degilevich.dream.shared.core.service.api.model.method.getTrack.GetTrackRequest
import and.degilevich.dream.shared.core.service.api.model.method.getTrack.GetTrackResponse
import and.degilevich.dream.shared.core.service.api.model.method.search.SearchRequest
import and.degilevich.dream.shared.core.service.api.model.method.search.SearchResponse

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