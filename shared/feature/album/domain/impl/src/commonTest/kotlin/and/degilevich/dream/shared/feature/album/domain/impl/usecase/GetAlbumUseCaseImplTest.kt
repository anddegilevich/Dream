package and.degilevich.dream.shared.feature.album.domain.impl.usecase

import and.degilevich.dream.shared.feature.album.data.api.repository.AlbumRepository
import and.degilevich.dream.shared.feature.album.data.test.repository.FakeAlbumRepository
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumId
import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumResult
import and.degilevich.dream.shared.feature.album.model.core.test.data.albumData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class GetAlbumUseCaseImplTest {

    @Test
    fun `invoke - repository succeeds - returns the result unchanged`() = runTest {
        val album = albumData(id = "album-1")
        val albumRepository = FakeAlbumRepository(
            onGetAlbum = { Result.success(GetAlbumResult(album = album)) }
        )
        val useCase = createGetAlbumUseCase(albumRepository = albumRepository)
        val params = GetAlbumParams(id = AlbumId(value = "album-1"))
        val result = useCase(params)
        result shouldBe Result.success(GetAlbumResult(album = album))
    }

    @Test
    fun `invoke - repository fails - returns failure`() = runTest {
        val error = IllegalStateException("network error")
        val albumRepository = FakeAlbumRepository(
            onGetAlbum = { Result.failure(error) }
        )
        val useCase = createGetAlbumUseCase(albumRepository = albumRepository)
        val params = GetAlbumParams(id = AlbumId(value = "album-1"))
        val result = useCase(params)
        assertTrue(result.isFailure)
    }

    @Test
    fun `invoke - any params - passes them to the repository unchanged`() = runTest {
        val receivedParams = mutableListOf<GetAlbumParams>()
        val albumRepository = FakeAlbumRepository(
            onGetAlbum = { params ->
                receivedParams.add(params)
                Result.success(GetAlbumResult(album = albumData(id = "album-1")))
            }
        )
        val useCase = createGetAlbumUseCase(albumRepository = albumRepository)
        val params = GetAlbumParams(id = AlbumId(value = "album-1"))
        useCase(params)
        receivedParams shouldBe listOf(params)
    }

    private fun createGetAlbumUseCase(
        albumRepository: AlbumRepository
    ) = GetAlbumUseCaseImpl(
        albumRepository = albumRepository
    )
}
