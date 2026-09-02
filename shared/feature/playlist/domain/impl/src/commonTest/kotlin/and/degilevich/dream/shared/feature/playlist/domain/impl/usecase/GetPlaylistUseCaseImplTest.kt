package and.degilevich.dream.shared.feature.playlist.domain.impl.usecase

import and.degilevich.dream.shared.feature.playlist.data.test.repository.FakePlaylistRepository
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.PlaylistId
import and.degilevich.dream.shared.feature.playlist.model.core.api.data.PlaylistData
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylist.GetPlaylistParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylist.GetPlaylistResult
import and.degilevich.dream.shared.feature.playlist.model.core.test.data.playlistData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class GetPlaylistUseCaseImplTest {

    @Test
    fun `invoke - repository succeeds - caches the returned playlist and returns the result unchanged`() = runTest {
        val playlist = playlistData(id = "playlist-1")
        val expected = Result.success(GetPlaylistResult(playlist = playlist))
        val cachedPlaylists = mutableListOf<PlaylistData>()
        val useCase = GetPlaylistUseCaseImpl(
            playlistRepository = FakePlaylistRepository(
                onGetPlaylist = { expected },
                onCachePlaylist = { cachedPlaylists.add(it) }
            )
        )

        val result = useCase(params())

        result shouldBe expected
        cachedPlaylists shouldBe listOf(playlist)
    }

    @Test
    fun `invoke - repository fails - returns failure without caching`() = runTest {
        val cachedPlaylists = mutableListOf<PlaylistData>()
        val useCase = GetPlaylistUseCaseImpl(
            playlistRepository = FakePlaylistRepository(
                onGetPlaylist = { Result.failure(IllegalStateException("network error")) },
                onCachePlaylist = { cachedPlaylists.add(it) }
            )
        )

        val result = useCase(params())

        assertTrue(result.isFailure)
        cachedPlaylists shouldBe emptyList()
    }

    @Test
    fun `invoke - passes params through to the repository unchanged`() = runTest {
        val receivedParams = mutableListOf<GetPlaylistParams>()
        val useCase = GetPlaylistUseCaseImpl(
            playlistRepository = FakePlaylistRepository(
                onGetPlaylist = { params ->
                    receivedParams.add(params)
                    Result.success(GetPlaylistResult(playlist = playlistData(id = "playlist-9")))
                },
                onCachePlaylist = {}
            )
        )
        val params = params(id = "playlist-9")

        useCase(params)

        receivedParams shouldBe listOf(params)
    }

    private fun params(id: String = "playlist-1") = GetPlaylistParams(id = PlaylistId(value = id))
}
