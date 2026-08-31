package and.degilevich.dream.shared.feature.user.data.impl.remote

import and.degilevich.dream.shared.feature.user.model.core.api.method.getCurrentUser.GetCurrentUserResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeUserRemoteDataSource(
    private val onGetCurrentUser: () -> Result<GetCurrentUserResult> = { fakeImplementationError() }
) : UserRemoteDataSource {

    override suspend fun getCurrentUser(): Result<GetCurrentUserResult> = onGetCurrentUser()
}
