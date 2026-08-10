package and.degilevich.dream.shared.feature.artist.domain.usecase

import and.degilevich.dream.shared.feature.artist.data.test.repository.FakeArtistRepository
import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.ArtistId
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.model.core.test.data.artistData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class GetArtistUseCaseImplTest {

    @Test
    fun `invoke - repository succeeds - caches the returned artist and returns the result unchanged`() = runTest {
        val artist = artistData(id = "artist-1")
        val cachedArtists = mutableListOf<ArtistData>()
        val artistRepository = FakeArtistRepository(
            onGetArtist = { Result.success(GetArtistResult(artist = artist)) },
            onCacheArtist = { cachedArtists.add(it) }
        )
        val useCase = GetArtistUseCaseImpl(artistRepository = artistRepository)
        val result = useCase(
            params = GetArtistParams(
                id = ArtistId(value = "artist-1")
            )
        )
        result shouldBe Result.success(GetArtistResult(artist = artist))
        cachedArtists shouldBe listOf(artist)
    }

    @Test
    fun `invoke - repository fails - returns failure without caching`() = runTest {
        val error = IllegalStateException("network error")
        val cachedArtists = mutableListOf<ArtistData>()
        val artistRepository = FakeArtistRepository(
            onGetArtist = { Result.failure(error) },
            onCacheArtist = { cachedArtists.add(it) }
        )
        val useCase = GetArtistUseCaseImpl(artistRepository = artistRepository)
        val result = useCase(
            params = GetArtistParams(
                id = ArtistId(value = "artist-1")
            )
        )
        assertTrue(result.isFailure)
        cachedArtists shouldBe emptyList()
    }
}
