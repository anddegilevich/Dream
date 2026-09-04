package and.degilevich.dream.shared.feature.playlist.domain.impl.usecase

import and.degilevich.dream.shared.feature.playlist.data.test.repository.FakePlaylistRepository
import and.degilevich.dream.shared.feature.playlist.model.artifact.test.data.simplifiedPlaylistData
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsResult
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class GetCurrentUserPlaylistsUseCaseImplTest {

    @Test
    fun `invoke - repository succeeds - returns the result unchanged`() = runTest {
        val playlists = listOf(
            simplifiedPlaylistData(id = "playlist-1"),
            simplifiedPlaylistData(id = "playlist-2")
        )
        val expected = Result.success(GetCurrentUserPlaylistsResult(playlists = playlists))
        val useCase = GetCurrentUserPlaylistsUseCaseImpl(
            playlistRepository = FakePlaylistRepository(
                onGetCurrentUserPlaylists = { expected }
            )
        )

        val result = useCase(params())

        result shouldBe expected
    }

    @Test
    fun `invoke - repository fails - returns failure`() = runTest {
        val useCase = GetCurrentUserPlaylistsUseCaseImpl(
            playlistRepository = FakePlaylistRepository(
                onGetCurrentUserPlaylists = { Result.failure(IllegalStateException("network error")) }
            )
        )

        val result = useCase(params())

        assertTrue(result.isFailure)
    }

    @Test
    fun `invoke - passes params through to the repository unchanged`() = runTest {
        val receivedParams = mutableListOf<GetCurrentUserPlaylistsParams>()
        val useCase = GetCurrentUserPlaylistsUseCaseImpl(
            playlistRepository = FakePlaylistRepository(
                onGetCurrentUserPlaylists = { params ->
                    receivedParams.add(params)
                    Result.success(GetCurrentUserPlaylistsResult(playlists = emptyList()))
                }
            )
        )
        val params = params(
            limit = 5,
            offset = 20
        )

        useCase(params)

        receivedParams shouldBe listOf(params)
    }

    private fun params(
        limit: Int = 10,
        offset: Int = 0
    ) = GetCurrentUserPlaylistsParams(
        limit = limit,
        offset = offset
    )
}
