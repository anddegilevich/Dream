package and.degilevich.dream.shared.feature.album.domain.impl.usecase

import and.degilevich.dream.shared.feature.album.data.api.repository.AlbumRepository
import and.degilevich.dream.shared.feature.album.data.test.repository.FakeAlbumRepository
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumId
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumData
import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumResult
import and.degilevich.dream.shared.feature.album.model.core.test.data.albumData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class GetAlbumUseCaseImplTest {

    @Test
    fun `invoke - repository succeeds - caches the returned album and returns the result unchanged`() = runTest {
        val album = albumData(id = "album-1")
        val cachedAlbums = mutableListOf<AlbumData>()
        val albumRepository = FakeAlbumRepository(
            onGetAlbum = { Result.success(GetAlbumResult(album = album)) },
            onCacheAlbum = { cachedAlbums.add(it) }
        )
        val useCase = createGetAlbumUseCase(albumRepository = albumRepository)
        val params = GetAlbumParams(id = AlbumId(value = "album-1"))
        val result = useCase(params)
        result shouldBe Result.success(GetAlbumResult(album = album))
        cachedAlbums shouldBe listOf(album)
    }

    @Test
    fun `invoke - repository fails - returns failure without caching`() = runTest {
        val error = IllegalStateException("network error")
        val cachedAlbums = mutableListOf<AlbumData>()
        val albumRepository = FakeAlbumRepository(
            onGetAlbum = { Result.failure(error) },
            onCacheAlbum = { cachedAlbums.add(it) }
        )
        val useCase = createGetAlbumUseCase(albumRepository = albumRepository)
        val params = GetAlbumParams(id = AlbumId(value = "album-1"))
        val result = useCase(params)
        assertTrue(result.isFailure)
        cachedAlbums shouldBe emptyList()
    }

    private fun createGetAlbumUseCase(
        albumRepository: AlbumRepository
    ) = GetAlbumUseCaseImpl(
        albumRepository = albumRepository
    )
}
