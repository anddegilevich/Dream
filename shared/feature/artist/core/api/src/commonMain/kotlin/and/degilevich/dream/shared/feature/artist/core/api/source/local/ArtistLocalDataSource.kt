package and.degilevich.dream.shared.feature.artist.core.api.source.local

import and.degilevich.dream.shared.template.source.local.LocalDataSource
import and.degilevich.dream.shared.feature.artist.model.core.ArtistData
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsRequest
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsResponse

interface ArtistLocalDataSource : LocalDataSource {
    suspend fun getArtist(id: String): Result<ArtistData>
    suspend fun saveArtist(artist: ArtistData): Result<Boolean>
    suspend fun getArtists(request: GetArtistsRequest): Result<GetArtistsResponse>
}