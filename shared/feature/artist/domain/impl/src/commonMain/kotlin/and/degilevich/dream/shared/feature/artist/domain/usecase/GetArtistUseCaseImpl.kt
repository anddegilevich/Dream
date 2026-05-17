package and.degilevich.dream.shared.feature.artist.domain.usecase

import and.degilevich.dream.shared.feature.artist.data.api.repository.ArtistRepository
import and.degilevich.dream.shared.feature.artist.domain.api.usecase.GetArtistUseCase
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtist.GetArtistResult

internal class GetArtistUseCaseImpl(
    private val artistRepository: ArtistRepository
) : GetArtistUseCase {

    override suspend fun invoke(params: GetArtistParams): Result<GetArtistResult> {
        return artistRepository.getArtist(params = params).onSuccess { result ->
            artistRepository.cacheArtist(artist = result.artist)
        }
    }
}
