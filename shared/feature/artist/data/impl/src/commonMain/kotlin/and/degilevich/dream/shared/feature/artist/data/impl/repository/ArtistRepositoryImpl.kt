package and.degilevich.dream.shared.feature.artist.data.impl.repository

import and.degilevich.dream.shared.feature.artist.data.api.repository.ArtistRepository
import and.degilevich.dream.shared.feature.artist.data.impl.local.ArtistLocalDataSource
import and.degilevich.dream.shared.feature.artist.data.impl.remote.ArtistRemoteDataSource
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtistAlbums.GetArtistAlbumsParams
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtistAlbums.GetArtistAlbumsResult

internal class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource
) : ArtistRepository {

    override suspend fun getArtist(params: GetArtistParams): Result<GetArtistResult> {
        return artistRemoteDataSource.getArtist(params = params)
    }

    override suspend fun getArtistAlbums(params: GetArtistAlbumsParams): Result<GetArtistAlbumsResult> {
        return artistRemoteDataSource.getArtistAlbums(params = params)
    }

    override suspend fun cacheArtist(artist: ArtistData) {
        artistLocalDataSource.saveArtist(artist = artist)
    }

    override suspend fun cacheArtists(artists: List<ArtistData>) {
        artistLocalDataSource.saveArtists(artists = artists)
    }
}
