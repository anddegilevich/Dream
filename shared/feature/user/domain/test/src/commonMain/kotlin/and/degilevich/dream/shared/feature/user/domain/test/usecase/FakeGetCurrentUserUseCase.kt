package and.degilevich.dream.shared.feature.user.domain.test.usecase

import and.degilevich.dream.shared.feature.user.domain.api.usecase.GetCurrentUserUseCase
import and.degilevich.dream.shared.feature.user.model.core.api.method.getCurrentUser.GetCurrentUserResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeGetCurrentUserUseCase(
    private val onInvoke: suspend () -> Result<GetCurrentUserResult> = { fakeImplementationError() }
) : GetCurrentUserUseCase {

    override suspend fun invoke(): Result<GetCurrentUserResult> = onInvoke()
}
