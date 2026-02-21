package and.degilevich.dream.shared.feature.artist.domain.usecase

import and.degilevich.dream.shared.feature.artist.domain.api.usecase.FetchArtistTopTracksUseCase
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistTopTracks.GetArtistTopTracksParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistTopTracks.GetArtistTopTracksResult
import and.degilevich.dream.shared.feature.artist.source.api.remote.ArtistRemoteDataSource
import and.degilevich.dream.shared.feature.track.source.api.local.TrackLocalDataSource

internal class FetchArtistTopTracksUseCaseImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val trackLocalDataSource: TrackLocalDataSource
) : FetchArtistTopTracksUseCase {

    override suspend fun invoke(params: GetArtistTopTracksParams): Result<GetArtistTopTracksResult> {
        return artistRemoteDataSource.getArtistTopTracks(params = params).onSuccess { result ->
            trackLocalDataSource.saveTracks(tracks = result.tracks)
        }
    }
}