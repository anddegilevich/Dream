package and.degilevich.dream.shared.feature.auth.domain.impl.usecase

import and.degilevich.dream.shared.feature.auth.data.api.repository.AuthRepository
import and.degilevich.dream.shared.feature.auth.domain.api.usecase.HasActiveSessionUseCase

internal class HasActiveSessionUseCaseImpl(
    private val authRepository: AuthRepository
) : HasActiveSessionUseCase {

    override suspend fun invoke(): Boolean {
        return runCatching {
            authRepository.hasActiveSession()
        }.getOrDefault(defaultValue = false)
    }
}
