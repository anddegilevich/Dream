package and.degilevich.dream.shared.feature.user.domain.impl.usecase

import and.degilevich.dream.shared.feature.user.data.test.repository.FakeUserRepository
import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import and.degilevich.dream.shared.feature.user.model.core.api.method.getCurrentUser.GetCurrentUserResult
import and.degilevich.dream.shared.feature.user.model.core.test.data.userData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class GetCurrentUserUseCaseImplTest {

    @Test
    fun `invoke - repository succeeds - caches the user and returns the result unchanged`() = runTest {
        val user = userData(id = "user-1")
        val cachedUsers = mutableListOf<UserData>()
        val useCase = GetCurrentUserUseCaseImpl(
            userRepository = FakeUserRepository(
                onGetCurrentUser = { Result.success(GetCurrentUserResult(user = user)) },
                onCacheUser = { cachedUsers.add(it) }
            )
        )
        val result = useCase()
        result shouldBe Result.success(GetCurrentUserResult(user = user))
        cachedUsers shouldBe listOf(user)
    }

    @Test
    fun `invoke - repository fails and a user is cached - returns the cached user`() = runTest {
        val cachedUser = userData(id = "cached-user")
        val useCase = GetCurrentUserUseCaseImpl(
            userRepository = FakeUserRepository(
                onGetCurrentUser = { Result.failure(IllegalStateException("network error")) },
                onGetCachedUser = { cachedUser }
            )
        )
        val result = useCase()
        result shouldBe Result.success(GetCurrentUserResult(user = cachedUser))
    }

    @Test
    fun `invoke - repository fails and no user is cached - returns failure`() = runTest {
        val useCase = GetCurrentUserUseCaseImpl(
            userRepository = FakeUserRepository(
                onGetCurrentUser = { Result.failure(IllegalStateException("network error")) },
                onGetCachedUser = { null }
            )
        )
        val result = useCase()
        assertTrue(result.isFailure)
    }
}
