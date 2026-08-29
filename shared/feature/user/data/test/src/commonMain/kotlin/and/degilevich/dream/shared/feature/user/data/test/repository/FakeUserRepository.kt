package and.degilevich.dream.shared.feature.user.data.test.repository

import and.degilevich.dream.shared.feature.user.data.api.repository.UserRepository
import and.degilevich.dream.shared.feature.user.model.core.api.method.getCurrentUser.GetCurrentUserResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeUserRepository(
    private val onGetCurrentUser: () -> Result<GetCurrentUserResult> = { fakeImplementationError() }
) : UserRepository {

    override suspend fun getCurrentUser(): Result<GetCurrentUserResult> = onGetCurrentUser()
}
