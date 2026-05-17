package and.degilevich.dream.shared.feature.artist.domain.usecase

import and.degilevich.dream.shared.feature.artist.domain.api.usecase.GetArtistsUseCase
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtists.GetArtistsResult
import and.degilevich.dream.shared.feature.artist.data.api.local.ArtistLocalDataSource
import and.degilevich.dream.shared.feature.artist.data.api.remote.ArtistRemoteDataSource

internal class GetArtistsUseCaseImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource
) : GetArtistsUseCase {

    override suspend fun invoke(params: GetArtistsParams): Result<GetArtistsResult> {
        return runCatching {
            val results = params.ids.map { id ->
                artistRemoteDataSource.getArtist(
                    params = GetArtistParams(id = id)
                ).getOrThrow()
            }
            GetArtistsResult(
                artists = results.map { it.artist }
            )
        }.onSuccess { result ->
            artistLocalDataSource.saveArtists(artists = result.artists)
        }
    }
}