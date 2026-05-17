package and.degilevich.dream.shared.feature.artist.domain.usecase

import and.degilevich.dream.shared.feature.artist.data.api.repository.ArtistRepository
import and.degilevich.dream.shared.feature.artist.domain.api.usecase.GetArtistsUseCase
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtists.GetArtistsResult

internal class GetArtistsUseCaseImpl(
    private val artistRepository: ArtistRepository
) : GetArtistsUseCase {

    override suspend fun invoke(params: GetArtistsParams): Result<GetArtistsResult> {
        return runCatching {
            val results = params.ids.map { id ->
                artistRepository.getArtist(
                    params = GetArtistParams(id = id)
                ).getOrThrow()
            }
            GetArtistsResult(
                artists = results.map { it.artist }
            )
        }.onSuccess { result ->
            artistRepository.cacheArtists(artists = result.artists)
        }
    }
}