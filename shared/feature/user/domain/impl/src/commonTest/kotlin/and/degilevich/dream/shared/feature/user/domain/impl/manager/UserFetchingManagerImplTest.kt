package and.degilevich.dream.shared.feature.user.domain.impl.manager

import and.degilevich.dream.shared.feature.user.data.api.repository.UserRepository
import and.degilevich.dream.shared.feature.user.data.test.repository.FakeUserRepository
import and.degilevich.dream.shared.feature.user.domain.api.usecase.GetCurrentUserUseCase
import and.degilevich.dream.shared.feature.user.domain.test.usecase.FakeGetCurrentUserUseCase
import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import and.degilevich.dream.shared.feature.user.model.core.api.method.getCurrentUser.GetCurrentUserResult
import and.degilevich.dream.shared.feature.user.model.core.test.data.userData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.async
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.time.Duration.Companion.seconds
import kotlin.time.TestTimeSource

class UserFetchingManagerImplTest {

    @Test
    fun `fetch - no previous update - fetches the user and returns it`() = runTest {
        val user = userData(id = "user-1")
        val manager = createManager(
            getCurrentUserUseCase = FakeGetCurrentUserUseCase(
                onInvoke = { Result.success(GetCurrentUserResult(user = user)) }
            )
        )
        val result = manager.fetch()
        result shouldBe Result.success(user)
    }

    @Test
    fun `fetch - called again inside the debounce window - returns the stored user without fetching`() = runTest {
        var invocationCount = 0
        var cachedUserReadCount = 0
        val fetchedUser = userData(id = "fetched-user")
        val storedUser = userData(id = "stored-user")
        val timeSource = TestTimeSource()
        val manager = createManager(
            getCurrentUserUseCase = FakeGetCurrentUserUseCase(
                onInvoke = {
                    invocationCount++
                    Result.success(GetCurrentUserResult(user = fetchedUser))
                }
            ),
            userRepository = FakeUserRepository(
                onGetCachedUser = {
                    cachedUserReadCount++
                    Result.success(storedUser)
                }
            ),
            timeSource = timeSource
        )
        manager.fetch()
        timeSource += 29.seconds
        val result = manager.fetch()
        result shouldBe Result.success(storedUser)
        invocationCount shouldBe 1
        cachedUserReadCount shouldBe 1
    }

    @Test
    fun `fetch - inside the debounce window and the storage read fails - returns the storage failure`() = runTest {
        val storageError = Result.failure<UserData>(IllegalStateException("no stored user"))
        val timeSource = TestTimeSource()
        val manager = createManager(
            getCurrentUserUseCase = FakeGetCurrentUserUseCase(
                onInvoke = { Result.success(GetCurrentUserResult(user = userData(id = "user-1"))) }
            ),
            userRepository = FakeUserRepository(onGetCachedUser = { storageError }),
            timeSource = timeSource
        )
        manager.fetch()
        timeSource += 29.seconds
        val result = manager.fetch()
        result shouldBe storageError
    }

    @Test
    fun `fetch - called after the debounce window - fetches again`() = runTest {
        var invocationCount = 0
        val timeSource = TestTimeSource()
        val manager = createManager(
            getCurrentUserUseCase = FakeGetCurrentUserUseCase(
                onInvoke = {
                    invocationCount++
                    Result.success(GetCurrentUserResult(user = userData(id = "user-$invocationCount")))
                }
            ),
            timeSource = timeSource
        )
        manager.fetch()
        timeSource += 31.seconds
        val result = manager.fetch()
        result shouldBe Result.success(userData(id = "user-2"))
        invocationCount shouldBe 2
    }

    @Test
    fun `fetch - fetch fails - returns the failure and does not start the debounce window`() = runTest {
        var invocationCount = 0
        val user = userData(id = "user-1")
        val manager = createManager(
            getCurrentUserUseCase = FakeGetCurrentUserUseCase(
                onInvoke = {
                    invocationCount++
                    if (invocationCount == 1) {
                        Result.failure(IllegalStateException("network error"))
                    } else {
                        Result.success(GetCurrentUserResult(user = user))
                    }
                }
            )
        )
        val failedResult = manager.fetch()
        val retriedResult = manager.fetch()
        assertTrue(failedResult.isFailure)
        retriedResult shouldBe Result.success(user)
        invocationCount shouldBe 2
    }

    @Test
    fun `fetch - concurrent calls - performs a single fetch and returns the same user to both`() = runTest {
        var invocationCount = 0
        val user = userData(id = "user-1")
        val fetchGate = CompletableDeferred<Unit>()
        val manager = createManager(
            getCurrentUserUseCase = FakeGetCurrentUserUseCase(
                onInvoke = {
                    invocationCount++
                    fetchGate.await()
                    Result.success(GetCurrentUserResult(user = user))
                }
            ),
            userRepository = FakeUserRepository(onGetCachedUser = { Result.success(user) })
        )
        val firstUpdate = async { manager.fetch() }
        val secondUpdate = async { manager.fetch() }
        runCurrent()
        fetchGate.complete(Unit)
        firstUpdate.await() shouldBe Result.success(user)
        secondUpdate.await() shouldBe Result.success(user)
        invocationCount shouldBe 1
    }

    @Test
    fun `fetch - concurrent calls - the debounced one reads the user from the storage`() = runTest {
        val user = userData(id = "user-1")
        val fetchGate = CompletableDeferred<Unit>()
        var cachedUserReadCount = 0
        val manager = createManager(
            getCurrentUserUseCase = FakeGetCurrentUserUseCase(
                onInvoke = {
                    fetchGate.await()
                    Result.success(GetCurrentUserResult(user = user))
                }
            ),
            userRepository = FakeUserRepository(
                onGetCachedUser = {
                    cachedUserReadCount++
                    Result.success(user)
                }
            )
        )
        val firstUpdate = async { manager.fetch() }
        val secondUpdate = async { manager.fetch() }
        runCurrent()
        fetchGate.complete(Unit)
        firstUpdate.await()
        secondUpdate.await()
        cachedUserReadCount shouldBe 1
    }

    private fun createManager(
        getCurrentUserUseCase: GetCurrentUserUseCase = FakeGetCurrentUserUseCase(),
        userRepository: UserRepository = FakeUserRepository(),
        timeSource: TestTimeSource = TestTimeSource()
    ) = UserFetchingManagerImpl(
        getCurrentUserUseCase = getCurrentUserUseCase,
        userRepository = userRepository,
        timeSource = timeSource
    )
}
