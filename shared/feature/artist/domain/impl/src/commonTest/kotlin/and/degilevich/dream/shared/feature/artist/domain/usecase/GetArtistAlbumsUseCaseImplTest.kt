package and.degilevich.dream.shared.feature.artist.domain.usecase

import and.degilevich.dream.shared.feature.album.data.test.repository.FakeAlbumRepository
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.SimplifiedAlbumData
import and.degilevich.dream.shared.feature.album.model.artifact.test.data.simplifiedAlbumData
import and.degilevich.dream.shared.feature.artist.data.test.repository.FakeArtistRepository
import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.ArtistId
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistAlbums.GetArtistAlbumsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistAlbums.GetArtistAlbumsResult
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class GetArtistAlbumsUseCaseImplTest {

    @Test
    fun `invoke - repository succeeds - caches the returned albums and returns the result unchanged`() = runTest {
        val album = simplifiedAlbumData(id = "album-1")
        val getArtistAlbumsResult = Result.success(
            GetArtistAlbumsResult(
                total = 1,
                items = listOf(album)
            )
        )
        val cachedAlbums = mutableListOf<SimplifiedAlbumData>()
        val useCase = GetArtistAlbumsUseCaseImpl(
            artistRepository = FakeArtistRepository(onGetArtistAlbums = { getArtistAlbumsResult }),
            albumRepository = FakeAlbumRepository(onCacheAlbums = { cachedAlbums.addAll(it) })
        )
        val params = GetArtistAlbumsParams(
            id = ArtistId(value = "artist-1"),
            limit = 10,
            offset = 0
        )
        val result = useCase(params)
        result shouldBe getArtistAlbumsResult
        cachedAlbums shouldBe listOf(album)
    }

    @Test
    fun `invoke - repository fails - returns failure without caching`() = runTest {
        val error = IllegalStateException("network error")
        val cachedAlbums = mutableListOf<SimplifiedAlbumData>()
        val useCase = GetArtistAlbumsUseCaseImpl(
            artistRepository = FakeArtistRepository(onGetArtistAlbums = { Result.failure(error) }),
            albumRepository = FakeAlbumRepository(onCacheAlbums = { cachedAlbums.addAll(it) })
        )
        val params = GetArtistAlbumsParams(
            id = ArtistId(value = "artist-1"),
            limit = 10,
            offset = 0
        )
        val result = useCase(params)
        assertTrue(result.isFailure)
        cachedAlbums shouldBe emptyList()
    }
}
