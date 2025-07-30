package and.degilevich.dream.shared.feature.artist.domain.usecase

import and.degilevich.dream.shared.feature.artist.domain.api.usecase.FetchArtistRelatedArtistsUseCase
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistRelatedArtists.GetArtistRelatedArtistsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistRelatedArtists.GetArtistRelatedArtistsResult
import and.degilevich.dream.shared.feature.artist.source.api.remote.ArtistRemoteDataSource

internal class FetchArtistRelatedArtistsUseCaseImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource
) : FetchArtistRelatedArtistsUseCase {
    override suspend fun invoke(params: GetArtistRelatedArtistsParams): Result<GetArtistRelatedArtistsResult> {
        return artistRemoteDataSource.getArtistRelatedArtists(params)
    }
}