package and.degilevich.dream.shared.feature.base.domain.impl.paging

import and.degilevich.dream.shared.feature.base.domain.api.paging.model.PageData
import and.degilevich.dream.shared.feature.base.domain.impl.paging.TestPagingSource.Companion.PAGE_SIZE
import app.cash.turbine.test
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.statekeeper.StateKeeperDispatcher
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
class BasePagingSourceTest {

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
    fun `loadNextPage - first call - loads the first page and exposes data and total`() = runTest {
        val item = TestItem(value = "item-1")
        val requestedOffsets = mutableListOf<Int>()
        val pagingSource = TestPagingSource(
            onLoadPage = { _, offset ->
                requestedOffsets.add(offset)
                Result.success(
                    PageData(
                        items = listOf(item),
                        total = 5
                    )
                )
            }
        )

        pagingSource.loadNextPage()

        pagingSource.data.value shouldContainExactly listOf(item)
        pagingSource.totalCount.value shouldBe 5
        pagingSource.isLoading.value shouldBe false
        requestedOffsets shouldContainExactly listOf(0)
    }

    @Test
    fun `loadNextPage - called twice - loads consecutive pages and appends them`() = runTest {
        val firstPage = List(PAGE_SIZE) { index -> TestItem(value = "item-$index") }
        val secondPageItem = TestItem(value = "item-last")
        val requestedOffsets = mutableListOf<Int>()
        val pagingSource = TestPagingSource(
            onLoadPage = { _, offset ->
                requestedOffsets.add(offset)
                Result.success(
                    PageData(
                        items = if (offset == 0) firstPage else listOf(secondPageItem),
                        total = TOTAL_COUNT
                    )
                )
            }
        )

        pagingSource.loadNextPage()
        pagingSource.loadNextPage()

        pagingSource.data.value shouldContainExactly firstPage + secondPageItem
        requestedOffsets shouldContainExactly listOf(0, PAGE_SIZE)
    }

    @Test
    fun `loadNextPage - duplicated items returned - keeps them distinct by id`() = runTest {
        val duplicated = TestItem(value = "item-0")
        val firstPage = List(PAGE_SIZE) { index -> TestItem(value = "item-$index") }
        val pagingSource = TestPagingSource(
            onLoadPage = { _, offset ->
                Result.success(
                    PageData(
                        items = if (offset == 0) firstPage else listOf(duplicated),
                        total = TOTAL_COUNT
                    )
                )
            }
        )

        pagingSource.loadNextPage()
        pagingSource.loadNextPage()

        pagingSource.data.value shouldContainExactly firstPage
    }

    @Test
    fun `loadNextPage - all items loaded - does not request another page`() = runTest {
        var invocationCount = 0
        val pagingSource = TestPagingSource(
            onLoadPage = { _, _ ->
                invocationCount++
                Result.success(
                    PageData(
                        items = listOf(TestItem(value = "item-1")),
                        total = 1
                    )
                )
            }
        )

        pagingSource.loadNextPage()
        pagingSource.loadNextPage()

        invocationCount shouldBe 1
    }

    @Test
    fun `loadNextPage - full page but total reached - does not request another page`() = runTest {
        var invocationCount = 0
        val pagingSource = TestPagingSource(
            onLoadPage = { _, _ ->
                invocationCount++
                Result.success(
                    PageData(
                        items = List(PAGE_SIZE) { index -> TestItem(value = "item-$index") },
                        total = PAGE_SIZE
                    )
                )
            }
        )

        pagingSource.loadNextPage()
        pagingSource.loadNextPage()

        invocationCount shouldBe 1
    }

    @Test
    fun `loadNextPage - empty page returned - does not request another page`() = runTest {
        var invocationCount = 0
        val pagingSource = TestPagingSource(
            onLoadPage = { _, _ ->
                invocationCount++
                Result.success(
                    PageData(
                        items = emptyList(),
                        total = 10
                    )
                )
            }
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
        val pagingSource = TestPagingSource(
            onLoadPage = { _, _ ->
                invocationCount++
                loadStarted.complete(Unit)
                loadGate.await()
                Result.success(
                    PageData(
                        items = listOf(TestItem(value = "item-1")),
                        total = 5
                    )
                )
            }
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
    fun `loadNextPage - load fails - emits the error and stops loading`() = runTest {
        val error = IllegalStateException("network")
        val pagingSource = TestPagingSource(
            onLoadPage = { _, _ -> Result.failure(error) }
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
        val requestedOffsets = mutableListOf<Int>()
        var isFailing = true
        val item = TestItem(value = "item-1")
        val pagingSource = TestPagingSource(
            onLoadPage = { _, offset ->
                requestedOffsets.add(offset)
                if (isFailing) {
                    isFailing = false
                    Result.failure(IllegalStateException("network"))
                } else {
                    Result.success(
                        PageData(
                            items = listOf(item),
                            total = 5
                        )
                    )
                }
            }
        )

        pagingSource.loadNextPage()
        pagingSource.loadNextPage()

        pagingSource.data.value shouldContainExactly listOf(item)
        requestedOffsets shouldContainExactly listOf(0, 0)
    }

    @Test
    fun `loadFirstPage - nothing loaded yet - loads the first page`() = runTest {
        val requestedOffsets = mutableListOf<Int>()
        val pagingSource = TestPagingSource(
            onLoadPage = { _, offset ->
                requestedOffsets.add(offset)
                Result.success(
                    PageData(
                        items = List(PAGE_SIZE) { index -> TestItem(value = "item-$index") },
                        total = TOTAL_COUNT
                    )
                )
            }
        )

        pagingSource.loadFirstPage()

        requestedOffsets shouldContainExactly listOf(0)
    }

    @Test
    fun `loadFirstPage - a page is already loaded - does nothing`() = runTest {
        val requestedOffsets = mutableListOf<Int>()
        val pagingSource = TestPagingSource(
            onLoadPage = { _, offset ->
                requestedOffsets.add(offset)
                Result.success(
                    PageData(
                        items = List(PAGE_SIZE) { index -> TestItem(value = "item-$index") },
                        total = TOTAL_COUNT
                    )
                )
            }
        )

        pagingSource.loadFirstPage()
        pagingSource.loadFirstPage()

        requestedOffsets shouldContainExactly listOf(0)
    }

    @Test
    fun `reset - after a loaded page - clears the data and restarts from the first offset`() = runTest {
        val requestedOffsets = mutableListOf<Int>()
        val pagingSource = TestPagingSource(
            onLoadPage = { _, offset ->
                requestedOffsets.add(offset)
                Result.success(
                    PageData(
                        items = List(PAGE_SIZE) { index -> TestItem(value = "item-$index") },
                        total = TOTAL_COUNT
                    )
                )
            }
        )

        pagingSource.loadNextPage()
        pagingSource.reset()

        pagingSource.data.value.shouldBeEmpty()
        pagingSource.totalCount.value shouldBe 0

        pagingSource.loadNextPage()

        requestedOffsets shouldContainExactly listOf(0, 0)
    }

    @Test
    fun `reset - while a load is in progress - discards the in-flight page`() = runTest {
        val loadStarted = CompletableDeferred<Unit>()
        val loadGate = CompletableDeferred<Unit>()
        val pagingSource = TestPagingSource(
            onLoadPage = { _, _ ->
                loadStarted.complete(Unit)
                loadGate.await()
                Result.success(
                    PageData(
                        items = listOf(TestItem(value = "item-1")),
                        total = 5
                    )
                )
            }
        )

        val runningLoad = async { pagingSource.loadNextPage() }
        loadStarted.await()
        pagingSource.reset()
        loadGate.complete(Unit)
        runningLoad.await()

        pagingSource.data.value.shouldBeEmpty()
        pagingSource.totalCount.value shouldBe 0
    }

    @Test
    fun `init - always - registers the state supplier in the component context state keeper`() = runTest {
        val stateKeeper = StateKeeperDispatcher()

        TestPagingSource(
            componentContext = DefaultComponentContext(
                lifecycle = LifecycleRegistry(),
                stateKeeper = stateKeeper
            ),
            onLoadPage = { _, _ ->
                Result.success(
                    PageData(
                        items = emptyList(),
                        total = 0
                    )
                )
            }
        )

        stateKeeper.isRegistered(key = STATE_KEY) shouldBe true
    }

    @Test
    fun `init - state was saved before - restores the data and continues from the next offset`() = runTest {
        val firstPage = List(PAGE_SIZE) { index -> TestItem(value = "item-$index") }
        val savedStateKeeper = StateKeeperDispatcher()
        val savedSource = TestPagingSource(
            componentContext = DefaultComponentContext(
                lifecycle = LifecycleRegistry(),
                stateKeeper = savedStateKeeper
            ),
            onLoadPage = { _, _ ->
                Result.success(
                    PageData(
                        items = firstPage,
                        total = TOTAL_COUNT
                    )
                )
            }
        )
        savedSource.loadNextPage()

        val requestedOffsets = mutableListOf<Int>()
        val restoredSource = TestPagingSource(
            componentContext = DefaultComponentContext(
                lifecycle = LifecycleRegistry(),
                stateKeeper = StateKeeperDispatcher(savedState = savedStateKeeper.save())
            ),
            onLoadPage = { _, offset ->
                requestedOffsets.add(offset)
                Result.success(
                    PageData(
                        items = listOf(TestItem(value = "item-restored")),
                        total = TOTAL_COUNT
                    )
                )
            }
        )

        restoredSource.data.value shouldContainExactly firstPage
        restoredSource.totalCount.value shouldBe TOTAL_COUNT

        restoredSource.loadFirstPage()
        requestedOffsets.shouldBeEmpty()

        restoredSource.loadNextPage()
        requestedOffsets shouldContainExactly listOf(PAGE_SIZE)
    }

    @Test
    fun `init - lifecycle destroyed - unregisters the state supplier`() = runTest {
        val stateKeeper = StateKeeperDispatcher()
        val lifecycle = LifecycleRegistry()
        lifecycle.onCreate()

        TestPagingSource(
            componentContext = DefaultComponentContext(
                lifecycle = lifecycle,
                stateKeeper = stateKeeper
            ),
            onLoadPage = { _, _ ->
                Result.success(
                    PageData(
                        items = listOf(TestItem(value = "item-1")),
                        total = 5
                    )
                )
            }
        )
        stateKeeper.isRegistered(key = STATE_KEY) shouldBe true

        lifecycle.onDestroy()

        stateKeeper.isRegistered(key = STATE_KEY) shouldBe false
    }

    private companion object {
        const val TOTAL_COUNT = 100
        const val STATE_KEY = "TestPagingSource"
    }
}
