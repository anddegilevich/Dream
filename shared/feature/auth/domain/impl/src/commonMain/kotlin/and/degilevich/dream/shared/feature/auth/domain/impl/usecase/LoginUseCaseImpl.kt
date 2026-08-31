package and.degilevich.dream.shared.feature.auth.domain.impl.usecase

import and.degilevich.dream.shared.feature.auth.data.api.repository.AuthRepository
import and.degilevich.dream.shared.feature.auth.domain.api.usecase.LoginUseCase

internal class LoginUseCaseImpl(
    private val authRepository: AuthRepository
) : LoginUseCase {

    override suspend fun invoke(): Result<Unit> {
        return authRepository.login()
    }
}
