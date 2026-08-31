package and.degilevich.dream.shared.feature.user.domain.impl.usecase

import and.degilevich.dream.shared.feature.user.data.api.repository.UserRepository
import and.degilevich.dream.shared.feature.user.domain.api.usecase.GetCurrentUserUseCase
import and.degilevich.dream.shared.feature.user.model.core.api.method.getCurrentUser.GetCurrentUserResult
import and.degilevich.dream.shared.foundation.primitive.result.recoverResult

internal class GetCurrentUserUseCaseImpl(
    private val userRepository: UserRepository
) : GetCurrentUserUseCase {

    override suspend fun invoke(): Result<GetCurrentUserResult> {
        return fetchUser().recoverResult {
            getCachedUser()
        }
    }

    private suspend fun fetchUser(): Result<GetCurrentUserResult> {
        return userRepository.getCurrentUser().onSuccess { result ->
            userRepository.cacheUser(user = result.user)
        }
    }

    private suspend fun getCachedUser(): Result<GetCurrentUserResult> {
        return userRepository.getCachedUser().map { user ->
            GetCurrentUserResult(user = user)
        }
    }
}
