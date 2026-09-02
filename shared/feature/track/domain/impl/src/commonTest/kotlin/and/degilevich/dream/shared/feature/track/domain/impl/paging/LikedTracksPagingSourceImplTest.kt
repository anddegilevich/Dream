package and.degilevich.dream.shared.feature.track.domain.impl.paging

import and.degilevich.dream.shared.feature.track.domain.test.usecase.FakeGetSavedTracksUseCase
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksResult
import and.degilevich.dream.shared.feature.track.model.core.test.data.savedTrackData
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import app.cash.turbine.test
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LikedTracksPagingSourceImplTest {

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
    fun `loadNextPage - first call - loads the first page and exposes tracks and total`() = runTest {
        val track = savedTrackData(id = "track-1")
        val requestedParams = mutableListOf<GetSavedTracksParams>()
        val pagingSource = LikedTracksPagingSourceImpl(
            componentContext = DefaultComponentContext(lifecycle = LifecycleRegistry()),
            getSavedTracksUseCase = FakeGetSavedTracksUseCase(
                onInvoke = { params ->
                    requestedParams.add(params)
                    Result.success(
                        GetSavedTracksResult(
                            tracks = listOf(track),
                            total = 5
                        )
                    )
                }
            )
        )

        pagingSource.loadNextPage()

        pagingSource.data.value shouldContainExactly listOf(track)
        pagingSource.totalCount.value shouldBe 5
        pagingSource.isLoading.value shouldBe false
        requestedParams shouldContainExactly listOf(
            GetSavedTracksParams(
                limit = LikedTracksPagingSourceImpl.PAGE_SIZE,
                offset = 0
            )
        )
    }

    @Test
    fun `loadNextPage - called twice - loads consecutive pages and appends them`() = runTest {
        val firstPage = List(LikedTracksPagingSourceImpl.PAGE_SIZE) { index ->
            savedTrackData(id = "track-$index")
        }
        val secondPageTrack = savedTrackData(id = "track-last")
        val requestedParams = mutableListOf<GetSavedTracksParams>()
        val pagingSource = LikedTracksPagingSourceImpl(
            componentContext = DefaultComponentContext(lifecycle = LifecycleRegistry()),
            getSavedTracksUseCase = FakeGetSavedTracksUseCase(
                onInvoke = { params ->
                    requestedParams.add(params)
                    val tracks = if (params.offset == 0) firstPage else listOf(secondPageTrack)
                    Result.success(
                        GetSavedTracksResult(
                            tracks = tracks,
                            total = TOTAL_COUNT
                        )
                    )
                }
            )
        )

        pagingSource.loadNextPage()
        pagingSource.loadNextPage()

        pagingSource.data.value shouldContainExactly firstPage + secondPageTrack
        requestedParams shouldContainExactly listOf(
            GetSavedTracksParams(
                limit = LikedTracksPagingSourceImpl.PAGE_SIZE,
                offset = 0
            ),
            GetSavedTracksParams(
                limit = LikedTracksPagingSourceImpl.PAGE_SIZE,
                offset = LikedTracksPagingSourceImpl.PAGE_SIZE
            )
        )
    }

    @Test
    fun `loadNextPage - all tracks loaded - does not request another page`() = runTest {
        var invocationCount = 0
        val pagingSource = LikedTracksPagingSourceImpl(
            componentContext = DefaultComponentContext(lifecycle = LifecycleRegistry()),
            getSavedTracksUseCase = FakeGetSavedTracksUseCase(
                onInvoke = {
                    invocationCount++
                    Result.success(
                        GetSavedTracksResult(
                            tracks = listOf(savedTrackData(id = "track-1")),
                            total = 1
                        )
                    )
                }
            )
        )

        pagingSource.loadNextPage()
        pagingSource.loadNextPage()

        invocationCount shouldBe 1
    }

    @Test
    fun `loadNextPage - empty page returned - does not request another page`() = runTest {
        var invocationCount = 0
        val pagingSource = LikedTracksPagingSourceImpl(
            componentContext = DefaultComponentContext(lifecycle = LifecycleRegistry()),
            getSavedTracksUseCase = FakeGetSavedTracksUseCase(
                onInvoke = {
                    invocationCount++
                    Result.success(
                        GetSavedTracksResult(
                            tracks = emptyList(),
                            total = 10
                        )
                    )
                }
            )
        )

        pagingSource.loadNextPage()
        pagingSource.loadNextPage()

        invocationCount shouldBe 1
        pagingSource.data.value.shouldBeEmpty()
    }

    @Test
    fun `loadNextPage - another load in progress - is ignored`() = runTest {
        val loadStarted = CompletableDeferred<Unit>()
        val loadGate = CompletableDeferred<Unit>()
        var invocationCount = 0
        val pagingSource = LikedTracksPagingSourceImpl(
            componentContext = DefaultComponentContext(lifecycle = LifecycleRegistry()),
            getSavedTracksUseCase = FakeGetSavedTracksUseCase(
                onInvoke = {
                    invocationCount++
                    loadStarted.complete(Unit)
                    loadGate.await()
                    Result.success(
                        GetSavedTracksResult(
                            tracks = listOf(savedTrackData(id = "track-1")),
                            total = 5
                        )
                    )
                }
            )
        )

        val runningLoad = async { pagingSource.loadNextPage() }
        loadStarted.await()
        pagingSource.isLoading.value shouldBe true

        pagingSource.loadNextPage()

        invocationCount shouldBe 1
        loadGate.complete(Unit)
        runningLoad.await()
        pagingSource.isLoading.value shouldBe false
        invocationCount shouldBe 1
    }

    @Test
    fun `loadNextPage - use case fails - emits the error and stops loading`() = runTest {
        val error = IllegalStateException("network")
        val pagingSource = LikedTracksPagingSourceImpl(
            componentContext = DefaultComponentContext(lifecycle = LifecycleRegistry()),
            getSavedTracksUseCase = FakeGetSavedTracksUseCase(
                onInvoke = { Result.failure(error) }
            )
        )

        pagingSource.errors.test {
            pagingSource.loadNextPage()
            awaitItem() shouldBe error
        }
        pagingSource.data.value.shouldBeEmpty()
        pagingSource.isLoading.value shouldBe false
    }

    @Test
    fun `loadNextPage - called after a failure - retries the same page`() = runTest {
        val requestedParams = mutableListOf<GetSavedTracksParams>()
        var isFailing = true
        val track = savedTrackData(id = "track-1")
        val pagingSource = LikedTracksPagingSourceImpl(
            componentContext = DefaultComponentContext(lifecycle = LifecycleRegistry()),
            getSavedTracksUseCase = FakeGetSavedTracksUseCase(
                onInvoke = { params ->
                    requestedParams.add(params)
                    if (isFailing) {
                        isFailing = false
                        Result.failure(IllegalStateException("network"))
                    } else {
                        Result.success(
                            GetSavedTracksResult(
                                tracks = listOf(track),
                                total = 5
                            )
                        )
                    }
                }
            )
        )

        pagingSource.loadNextPage()
        pagingSource.loadNextPage()

        pagingSource.data.value shouldContainExactly listOf(track)
        requestedParams shouldContainExactly listOf(
            GetSavedTracksParams(
                limit = LikedTracksPagingSourceImpl.PAGE_SIZE,
                offset = 0
            ),
            GetSavedTracksParams(
                limit = LikedTracksPagingSourceImpl.PAGE_SIZE,
                offset = 0
            )
        )
    }

    private companion object {
        const val TOTAL_COUNT = 100
    }
}
