package and.degilevich.dream.shared.feature.user.domain.test.usecase

import and.degilevich.dream.shared.feature.user.domain.api.usecase.ObserveCurrentUserUseCase
import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError
import kotlinx.coroutines.flow.Flow

class FakeObserveCurrentUserUseCase(
    private val onInvoke: () -> Flow<UserData> = { fakeImplementationError() }
) : ObserveCurrentUserUseCase {

    override fun invoke(): Flow<UserData> = onInvoke()
}
