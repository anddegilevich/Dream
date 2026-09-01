package and.degilevich.dream.shared.feature.track.domain.impl.paging

import and.degilevich.dream.shared.feature.track.domain.test.usecase.FakeGetSavedTracksUseCase
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksResult
import and.degilevich.dream.shared.feature.track.model.core.test.data.savedTrackData
import app.cash.turbine.test
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.async
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class LikedTracksPagingSourceImplTest {

    @Test
    fun `loadMore - first call - loads the first page and exposes tracks and total`() = runTest {
        val track = savedTrackData(id = "track-1")
        val requestedParams = mutableListOf<GetSavedTracksParams>()
        val pagingSource = LikedTracksPagingSourceImpl(
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

        pagingSource.loadMore()

        pagingSource.tracks.value shouldContainExactly listOf(track)
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
    fun `loadMore - called twice - loads consecutive pages and appends them`() = runTest {
        val firstPage = List(LikedTracksPagingSourceImpl.PAGE_SIZE) { index ->
            savedTrackData(id = "track-$index")
        }
        val secondPageTrack = savedTrackData(id = "track-last")
        val requestedParams = mutableListOf<GetSavedTracksParams>()
        val pagingSource = LikedTracksPagingSourceImpl(
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

        pagingSource.loadMore()
        pagingSource.loadMore()

        pagingSource.tracks.value shouldContainExactly firstPage + secondPageTrack
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
    fun `loadMore - all tracks loaded - does not request another page`() = runTest {
        var invocationCount = 0
        val pagingSource = LikedTracksPagingSourceImpl(
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

        pagingSource.loadMore()
        pagingSource.loadMore()

        invocationCount shouldBe 1
    }

    @Test
    fun `loadMore - empty page returned - does not request another page`() = runTest {
        var invocationCount = 0
        val pagingSource = LikedTracksPagingSourceImpl(
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

        pagingSource.loadMore()
        pagingSource.loadMore()

        invocationCount shouldBe 1
        pagingSource.tracks.value.shouldBeEmpty()
    }

    @Test
    fun `loadMore - another load in progress - is ignored`() = runTest {
        val loadGate = CompletableDeferred<Unit>()
        var invocationCount = 0
        val pagingSource = LikedTracksPagingSourceImpl(
            getSavedTracksUseCase = FakeGetSavedTracksUseCase(
                onInvoke = {
                    invocationCount++
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

        val runningLoad = async { pagingSource.loadMore() }
        runCurrent()
        pagingSource.isLoading.value shouldBe true

        pagingSource.loadMore()

        invocationCount shouldBe 1
        loadGate.complete(Unit)
        runningLoad.await()
        pagingSource.isLoading.value shouldBe false
        invocationCount shouldBe 1
    }

    @Test
    fun `loadMore - use case fails - emits the error and stops loading`() = runTest {
        val error = IllegalStateException("network")
        val pagingSource = LikedTracksPagingSourceImpl(
            getSavedTracksUseCase = FakeGetSavedTracksUseCase(
                onInvoke = { Result.failure(error) }
            )
        )

        pagingSource.errors.test {
            pagingSource.loadMore()
            awaitItem() shouldBe error
        }
        pagingSource.tracks.value.shouldBeEmpty()
        pagingSource.isLoading.value shouldBe false
    }

    @Test
    fun `loadMore - called after a failure - retries the same page`() = runTest {
        val requestedParams = mutableListOf<GetSavedTracksParams>()
        var isFailing = true
        val track = savedTrackData(id = "track-1")
        val pagingSource = LikedTracksPagingSourceImpl(
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

        pagingSource.loadMore()
        pagingSource.loadMore()

        pagingSource.tracks.value shouldContainExactly listOf(track)
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
