package and.degilevich.dream.shared.feature.auth.domain.impl.usecase

import and.degilevich.dream.shared.feature.auth.data.api.repository.AuthRepository
import and.degilevich.dream.shared.feature.auth.domain.api.usecase.ObserveHasActiveSessionUseCase
import kotlinx.coroutines.flow.Flow

internal class ObserveHasActiveSessionUseCaseImpl(
    private val authRepository: AuthRepository
) : ObserveHasActiveSessionUseCase {

    override fun invoke(): Flow<Boolean> {
        return authRepository.observeHasActiveSession()
    }
}
