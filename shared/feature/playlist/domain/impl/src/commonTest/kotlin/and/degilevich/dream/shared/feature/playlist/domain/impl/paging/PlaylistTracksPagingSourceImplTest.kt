package and.degilevich.dream.shared.feature.playlist.domain.impl.paging

import and.degilevich.dream.shared.feature.playlist.domain.test.usecase.FakeGetPlaylistTracksUseCase
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.PlaylistId
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksResult
import and.degilevich.dream.shared.feature.playlist.model.core.test.data.playlistTrackData
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import app.cash.turbine.test
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class PlaylistTracksPagingSourceImplTest {

    private val testDispatcher = StandardTestDispatcher()

    @BeforeTest
    fun setUp() {
        Dispatchers.setMain(dispatcher = testDispatcher)
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loadNextPage - playlist id set - loads the first page and exposes tracks and total`() = runTest {
        val track = playlistTrackData(id = "track-1")
        val requestedParams = mutableListOf<GetPlaylistTracksParams>()
        val pagingSource = createPagingSource(
            getPlaylistTracksUseCase = FakeGetPlaylistTracksUseCase(
                onInvoke = { params ->
                    requestedParams.add(params)
                    Result.success(
                        GetPlaylistTracksResult(
                            tracks = listOf(track),
                            total = 5
                        )
                    )
                }
            )
        )
        pagingSource.setPlaylistId(id = PlaylistId(value = "playlist-1"))

        pagingSource.loadNextPage()

        pagingSource.data.value shouldContainExactly listOf(track)
        pagingSource.totalCount.value shouldBe 5
        pagingSource.isLoading.value shouldBe false
        requestedParams shouldContainExactly listOf(
            GetPlaylistTracksParams(
                id = PlaylistId(value = "playlist-1"),
                limit = PlaylistTracksPagingSourceImpl.PAGE_SIZE,
                offset = 0
            )
        )
    }

    @Test
    fun `loadNextPage - playlist id not set - does not request a page`() = runTest {
        var invocationCount = 0
        val pagingSource = createPagingSource(
            getPlaylistTracksUseCase = FakeGetPlaylistTracksUseCase(
                onInvoke = {
                    invocationCount++
                    Result.success(GetPlaylistTracksResult(tracks = emptyList(), total = 0))
                }
            )
        )

        pagingSource.loadNextPage()

        invocationCount shouldBe 0
        pagingSource.data.value.shouldBeEmpty()
    }

    @Test
    fun `loadNextPage - called twice - loads consecutive pages and appends them`() = runTest {
        val firstPage = List(PlaylistTracksPagingSourceImpl.PAGE_SIZE) { index ->
            playlistTrackData(id = "track-$index")
        }
        val secondPageTrack = playlistTrackData(id = "track-last")
        val requestedParams = mutableListOf<GetPlaylistTracksParams>()
        val pagingSource = createPagingSource(
            getPlaylistTracksUseCase = FakeGetPlaylistTracksUseCase(
                onInvoke = { params ->
                    requestedParams.add(params)
                    val tracks = if (params.offset == 0) firstPage else listOf(secondPageTrack)
                    Result.success(
                        GetPlaylistTracksResult(
                            tracks = tracks,
                            total = TOTAL_COUNT
                        )
                    )
                }
            )
        )
        pagingSource.setPlaylistId(id = PlaylistId(value = "playlist-1"))

        pagingSource.loadNextPage()
        pagingSource.loadNextPage()

        pagingSource.data.value shouldContainExactly firstPage + secondPageTrack
        requestedParams.map { it.offset } shouldContainExactly listOf(0, PlaylistTracksPagingSourceImpl.PAGE_SIZE)
    }

    @Test
    fun `setPlaylistId - new id after a load - drops loaded tracks and reloads from the first page`() = runTest {
        val requestedParams = mutableListOf<GetPlaylistTracksParams>()
        val pagingSource = createPagingSource(
            getPlaylistTracksUseCase = FakeGetPlaylistTracksUseCase(
                onInvoke = { params ->
                    requestedParams.add(params)
                    Result.success(
                        GetPlaylistTracksResult(
                            tracks = listOf(playlistTrackData(id = "track-${params.id.value}")),
                            total = TOTAL_COUNT
                        )
                    )
                }
            )
        )
        pagingSource.setPlaylistId(id = PlaylistId(value = "playlist-1"))
        pagingSource.loadNextPage()

        pagingSource.setPlaylistId(id = PlaylistId(value = "playlist-2"))

        pagingSource.data.value.shouldBeEmpty()
        pagingSource.totalCount.value shouldBe 0

        pagingSource.loadNextPage()

        pagingSource.data.value shouldContainExactly listOf(playlistTrackData(id = "track-playlist-2"))
        requestedParams.map { it.id.value to it.offset } shouldContainExactly listOf(
            "playlist-1" to 0,
            "playlist-2" to 0
        )
    }

    @Test
    fun `setPlaylistId - same id twice - keeps loaded tracks`() = runTest {
        val track = playlistTrackData(id = "track-1")
        val pagingSource = createPagingSource(
            getPlaylistTracksUseCase = FakeGetPlaylistTracksUseCase(
                onInvoke = {
                    Result.success(
                        GetPlaylistTracksResult(
                            tracks = listOf(track),
                            total = TOTAL_COUNT
                        )
                    )
                }
            )
        )
        pagingSource.setPlaylistId(id = PlaylistId(value = "playlist-1"))
        pagingSource.loadNextPage()

        pagingSource.setPlaylistId(id = PlaylistId(value = "playlist-1"))

        pagingSource.data.value shouldContainExactly listOf(track)
    }

    @Test
    fun `loadNextPage - use case fails - emits the error and stops loading`() = runTest {
        val error = IllegalStateException("network")
        val pagingSource = createPagingSource(
            getPlaylistTracksUseCase = FakeGetPlaylistTracksUseCase(onInvoke = { Result.failure(error) })
        )
        pagingSource.setPlaylistId(id = PlaylistId(value = "playlist-1"))

        pagingSource.errors.test {
            pagingSource.loadNextPage()
            awaitItem() shouldBe error
        }
        pagingSource.data.value.shouldBeEmpty()
        pagingSource.isLoading.value shouldBe false
    }

    private fun createPagingSource(
        getPlaylistTracksUseCase: FakeGetPlaylistTracksUseCase = FakeGetPlaylistTracksUseCase()
    ) = PlaylistTracksPagingSourceImpl(
        componentContext = DefaultComponentContext(lifecycle = LifecycleRegistry()),
        getPlaylistTracksUseCase = getPlaylistTracksUseCase
    )

    private companion object {
        const val TOTAL_COUNT = 100
    }
}
