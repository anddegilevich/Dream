package and.degilevich.dream.shared.feature.artist.domain.usecase

import and.degilevich.dream.shared.feature.artist.data.test.repository.FakeArtistRepository
import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.ArtistId
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtists.GetArtistsResult
import and.degilevich.dream.shared.feature.artist.model.core.test.data.artistData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class GetArtistsUseCaseImplTest {

    @Test
    fun `invoke - multiple ids - fetches each artist and caches them all`() = runTest {
        val artistA = artistData(id = "artist-a")
        val artistB = artistData(id = "artist-b")
        val cachedArtists = mutableListOf<List<ArtistData>>()
        val artistRepository = FakeArtistRepository(
            onGetArtist = { params ->
                when (params.id.value) {
                    "artist-a" -> Result.success(GetArtistResult(artist = artistA))
                    else -> Result.success(GetArtistResult(artist = artistB))
                }
            },
            onCacheArtists = { cachedArtists.add(it) }
        )
        val useCase = GetArtistsUseCaseImpl(artistRepository = artistRepository)
        val params = GetArtistsParams(
            ids = listOf(
                ArtistId(value = "artist-a"),
                ArtistId(value = "artist-b")
            )
        )
        val result = useCase(params)
        result shouldBe Result.success(
            GetArtistsResult(
                artists = listOf(artistA, artistB)
            )
        )
        cachedArtists shouldBe listOf(listOf(artistA, artistB))
    }

    @Test
    fun `invoke - one artist fails - returns failure without caching`() = runTest {
        val error = IllegalStateException("network error")
        val cachedArtists = mutableListOf<List<ArtistData>>()
        val artistRepository = FakeArtistRepository(
            onGetArtist = { Result.failure(error) },
            onCacheArtists = { cachedArtists.add(it) }
        )
        val useCase = GetArtistsUseCaseImpl(artistRepository = artistRepository)
        val params = GetArtistsParams(ids = listOf(ArtistId(value = "artist-a")))
        val result = useCase(params)
        assertTrue(result.isFailure)
        cachedArtists shouldBe emptyList()
    }
}
