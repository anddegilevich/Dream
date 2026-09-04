package and.degilevich.dream.shared.feature.artist.domain.usecase

import and.degilevich.dream.shared.feature.artist.data.test.repository.FakeArtistRepository
import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.ArtistId
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.model.core.test.data.artistData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class GetArtistUseCaseImplTest {

    @Test
    fun `invoke - repository succeeds - returns the result unchanged`() = runTest {
        val artist = artistData(id = "artist-1")
        val artistRepository = FakeArtistRepository(
            onGetArtist = { Result.success(GetArtistResult(artist = artist)) }
        )
        val useCase = GetArtistUseCaseImpl(artistRepository = artistRepository)
        val result = useCase(
            params = GetArtistParams(
                id = ArtistId(value = "artist-1")
            )
        )
        result shouldBe Result.success(GetArtistResult(artist = artist))
    }

    @Test
    fun `invoke - repository fails - returns failure`() = runTest {
        val error = IllegalStateException("network error")
        val artistRepository = FakeArtistRepository(
            onGetArtist = { Result.failure(error) }
        )
        val useCase = GetArtistUseCaseImpl(artistRepository = artistRepository)
        val result = useCase(
            params = GetArtistParams(
                id = ArtistId(value = "artist-1")
            )
        )
        assertTrue(result.isFailure)
    }

    @Test
    fun `invoke - any params - passes them to the repository unchanged`() = runTest {
        val receivedParams = mutableListOf<GetArtistParams>()
        val artistRepository = FakeArtistRepository(
            onGetArtist = { params ->
                receivedParams.add(params)
                Result.success(GetArtistResult(artist = artistData(id = "artist-1")))
            }
        )
        val useCase = GetArtistUseCaseImpl(artistRepository = artistRepository)
        val params = GetArtistParams(id = ArtistId(value = "artist-1"))
        useCase(params = params)
        receivedParams shouldBe listOf(params)
    }
}
