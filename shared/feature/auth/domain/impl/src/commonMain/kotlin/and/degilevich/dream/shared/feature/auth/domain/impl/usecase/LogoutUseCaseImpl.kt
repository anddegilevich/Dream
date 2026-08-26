package and.degilevich.dream.shared.feature.auth.domain.impl.usecase

import and.degilevich.dream.shared.feature.auth.data.api.repository.AuthRepository
import and.degilevich.dream.shared.feature.auth.domain.api.usecase.LogoutUseCase

internal class LogoutUseCaseImpl(
    private val authRepository: AuthRepository
) : LogoutUseCase {

    override suspend fun invoke() {
        authRepository.logout()
    }
}
