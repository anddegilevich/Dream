package and.degilevich.dream.shared.feature.artist.domain.usecase

import and.degilevich.dream.shared.feature.artist.domain.api.usecase.FetchArtistRelatedArtistsUseCase
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistRelatedArtists.GetArtistRelatedArtistsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistRelatedArtists.GetArtistRelatedArtistsResult
import and.degilevich.dream.shared.feature.artist.source.api.local.ArtistLocalDataSource
import and.degilevich.dream.shared.feature.artist.source.api.remote.ArtistRemoteDataSource

internal class FetchArtistRelatedArtistsUseCaseImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource
) : FetchArtistRelatedArtistsUseCase {

    override suspend fun invoke(params: GetArtistRelatedArtistsParams): Result<GetArtistRelatedArtistsResult> {
        return artistRemoteDataSource.getArtistRelatedArtists(params = params).onSuccess { result ->
            artistLocalDataSource.saveArtists(artists = result.artists)
        }
    }
}