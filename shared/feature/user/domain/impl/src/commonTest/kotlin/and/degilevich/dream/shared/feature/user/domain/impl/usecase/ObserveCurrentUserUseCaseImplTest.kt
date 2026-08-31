package and.degilevich.dream.shared.feature.user.domain.impl.usecase

import and.degilevich.dream.shared.feature.user.data.test.repository.FakeUserRepository
import and.degilevich.dream.shared.feature.user.domain.test.manager.FakeUserFetchingManager
import and.degilevich.dream.shared.feature.user.model.core.test.data.userData
import app.cash.turbine.test
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class ObserveCurrentUserUseCaseImplTest {

    @Test
    fun `invoke - emits the users observed from the repository`() = runTest {
        val user = userData(id = "user-1")
        val useCase = ObserveCurrentUserUseCaseImpl(
            userRepository = FakeUserRepository(onObserveUser = { flowOf(user) }),
            userFetchingManager = FakeUserFetchingManager(onFetch = { Result.success(user) })
        )
        useCase().test {
            awaitItem() shouldBe user
            awaitComplete()
        }
    }

    @Test
    fun `invoke - storage holds no user - skips the null emissions`() = runTest {
        val user = userData(id = "user-1")
        val useCase = ObserveCurrentUserUseCaseImpl(
            userRepository = FakeUserRepository(onObserveUser = { flowOf(null, user, null) }),
            userFetchingManager = FakeUserFetchingManager(onFetch = { Result.success(user) })
        )
        useCase().test {
            awaitItem() shouldBe user
            awaitComplete()
        }
    }

    @Test
    fun `invoke - on subscription - triggers a single fetch`() = runTest {
        val user = userData(id = "user-1")
        var fetchCount = 0
        val useCase = ObserveCurrentUserUseCaseImpl(
            userRepository = FakeUserRepository(onObserveUser = { flowOf(user) }),
            userFetchingManager = FakeUserFetchingManager(
                onFetch = {
                    fetchCount++
                    Result.success(user)
                }
            )
        )
        useCase().test {
            awaitItem() shouldBe user
            awaitComplete()
        }
        fetchCount shouldBe 1
    }

    @Test
    fun `invoke - not collected - does not trigger a fetch`() = runTest {
        var fetchCount = 0
        val useCase = ObserveCurrentUserUseCaseImpl(
            userRepository = FakeUserRepository(onObserveUser = { flowOf(null) }),
            userFetchingManager = FakeUserFetchingManager(
                onFetch = {
                    fetchCount++
                    Result.success(userData(id = "user-1"))
                }
            )
        )
        useCase()
        fetchCount shouldBe 0
    }
}
