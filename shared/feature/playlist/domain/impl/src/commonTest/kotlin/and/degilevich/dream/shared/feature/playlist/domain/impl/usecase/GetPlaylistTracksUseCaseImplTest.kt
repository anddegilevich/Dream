package and.degilevich.dream.shared.feature.playlist.domain.impl.usecase

import and.degilevich.dream.shared.feature.playlist.data.test.repository.FakePlaylistRepository
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.PlaylistId
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksResult
import and.degilevich.dream.shared.feature.playlist.model.core.test.data.playlistTrackData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class GetPlaylistTracksUseCaseImplTest {

    @Test
    fun `invoke - repository succeeds - returns the result unchanged`() = runTest {
        val expected = Result.success(
            GetPlaylistTracksResult(
                tracks = listOf(playlistTrackData(id = "track-1")),
                total = 1
            )
        )
        val useCase = GetPlaylistTracksUseCaseImpl(
            playlistRepository = FakePlaylistRepository(onGetPlaylistTracks = { expected })
        )

        val result = useCase(params())

        result shouldBe expected
    }

    @Test
    fun `invoke - repository fails - returns failure`() = runTest {
        val useCase = GetPlaylistTracksUseCaseImpl(
            playlistRepository = FakePlaylistRepository(
                onGetPlaylistTracks = { Result.failure(IllegalStateException("network error")) }
            )
        )

        val result = useCase(params())

        assertTrue(result.isFailure)
    }

    @Test
    fun `invoke - passes params through to the repository unchanged`() = runTest {
        val receivedParams = mutableListOf<GetPlaylistTracksParams>()
        val useCase = GetPlaylistTracksUseCaseImpl(
            playlistRepository = FakePlaylistRepository(
                onGetPlaylistTracks = { params ->
                    receivedParams.add(params)
                    Result.success(GetPlaylistTracksResult(tracks = emptyList(), total = 0))
                }
            )
        )
        val params = params(
            id = "playlist-9",
            limit = 7,
            offset = 14
        )

        useCase(params)

        receivedParams shouldBe listOf(params)
    }

    private fun params(
        id: String = "playlist-1",
        limit: Int = 50,
        offset: Int = 0
    ) = GetPlaylistTracksParams(
        id = PlaylistId(value = id),
        limit = limit,
        offset = offset
    )
}
