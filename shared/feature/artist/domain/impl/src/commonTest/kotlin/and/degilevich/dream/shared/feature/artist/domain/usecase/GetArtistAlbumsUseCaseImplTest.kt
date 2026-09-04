package and.degilevich.dream.shared.feature.artist.domain.usecase

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
    fun `invoke - repository succeeds - returns the result unchanged`() = runTest {
        val album = simplifiedAlbumData(id = "album-1")
        val getArtistAlbumsResult = Result.success(
            GetArtistAlbumsResult(
                total = 1,
                items = listOf(album)
            )
        )
        val useCase = GetArtistAlbumsUseCaseImpl(
            artistRepository = FakeArtistRepository(onGetArtistAlbums = { getArtistAlbumsResult })
        )
        val params = GetArtistAlbumsParams(
            id = ArtistId(value = "artist-1"),
            limit = 10,
            offset = 0
        )
        val result = useCase(params)
        result shouldBe getArtistAlbumsResult
    }

    @Test
    fun `invoke - repository fails - returns failure`() = runTest {
        val error = IllegalStateException("network error")
        val useCase = GetArtistAlbumsUseCaseImpl(
            artistRepository = FakeArtistRepository(onGetArtistAlbums = { Result.failure(error) })
        )
        val params = GetArtistAlbumsParams(
            id = ArtistId(value = "artist-1"),
            limit = 10,
            offset = 0
        )
        val result = useCase(params)
        assertTrue(result.isFailure)
    }

    @Test
    fun `invoke - any params - passes them to the repository unchanged`() = runTest {
        val receivedParams = mutableListOf<GetArtistAlbumsParams>()
        val useCase = GetArtistAlbumsUseCaseImpl(
            artistRepository = FakeArtistRepository(
                onGetArtistAlbums = { params ->
                    receivedParams.add(params)
                    Result.success(
                        GetArtistAlbumsResult(
                            total = 0,
                            items = emptyList()
                        )
                    )
                }
            )
        )
        val params = GetArtistAlbumsParams(
            id = ArtistId(value = "artist-1"),
            limit = 10,
            offset = 0
        )
        useCase(params)
        receivedParams shouldBe listOf(params)
    }
}
