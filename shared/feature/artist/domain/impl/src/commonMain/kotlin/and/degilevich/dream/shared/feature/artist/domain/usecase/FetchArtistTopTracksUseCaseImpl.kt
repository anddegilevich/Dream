package and.degilevich.dream.shared.feature.artist.domain.usecase

import and.degilevich.dream.shared.feature.artist.domain.api.usecase.FetchArtistTopTracksUseCase
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistTopTracks.GetArtistTopTracksParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistTopTracks.GetArtistTopTracksResult
import and.degilevich.dream.shared.feature.artist.source.api.remote.ArtistRemoteDataSource

internal class FetchArtistTopTracksUseCaseImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource
) : FetchArtistTopTracksUseCase {
    override suspend fun invoke(params: GetArtistTopTracksParams): Result<GetArtistTopTracksResult> {
        return artistRemoteDataSource.getArtistTopTracks(params)
    }
}