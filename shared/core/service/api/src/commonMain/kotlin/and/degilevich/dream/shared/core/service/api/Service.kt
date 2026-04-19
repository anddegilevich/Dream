package and.degilevich.dream.shared.core.service.api

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

@Suppress("TooManyFunctions")
interface Service {
    // Artist
    suspend fun getArtist(request: GetArtistRequest): Result<GetArtistResponse>
    suspend fun getArtistAlbums(request: GetArtistAlbumsRequest): Result<GetArtistAlbumsResponse>

    // Album
    suspend fun getAlbum(request: GetAlbumRequest): Result<GetAlbumResponse>

    // Track
    suspend fun getTrack(request: GetTrackRequest): Result<GetTrackResponse>

    // Search
    suspend fun search(request: SearchRequest): Result<SearchResponse>
}