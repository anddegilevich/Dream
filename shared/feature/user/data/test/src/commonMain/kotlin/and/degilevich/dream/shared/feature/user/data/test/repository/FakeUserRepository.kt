package and.degilevich.dream.shared.feature.user.data.test.repository

import and.degilevich.dream.shared.feature.user.data.api.repository.UserRepository
import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import and.degilevich.dream.shared.feature.user.model.core.api.method.getCurrentUser.GetCurrentUserResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeUserRepository(
    private val onGetCurrentUser: () -> Result<GetCurrentUserResult> = { fakeImplementationError() },
    private val onCacheUser: (UserData) -> Unit = { fakeImplementationError() },
    private val onGetCachedUser: () -> UserData? = { fakeImplementationError() }
) : UserRepository {

    override suspend fun getCurrentUser(): Result<GetCurrentUserResult> = onGetCurrentUser()

    override suspend fun cacheUser(user: UserData) = onCacheUser(user)

    override suspend fun getCachedUser(): UserData? = onGetCachedUser()
}
