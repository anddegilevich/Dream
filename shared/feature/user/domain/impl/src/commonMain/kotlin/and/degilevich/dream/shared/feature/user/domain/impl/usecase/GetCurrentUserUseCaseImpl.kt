package and.degilevich.dream.shared.feature.user.domain.impl.usecase

import and.degilevich.dream.shared.feature.user.data.api.repository.UserRepository
import and.degilevich.dream.shared.feature.user.domain.api.usecase.GetCurrentUserUseCase
import and.degilevich.dream.shared.feature.user.model.core.api.method.getCurrentUser.GetCurrentUserResult

internal class GetCurrentUserUseCaseImpl(
    private val userRepository: UserRepository
) : GetCurrentUserUseCase {

    override suspend fun invoke(): Result<GetCurrentUserResult> {
        return userRepository.getCurrentUser().fold(
            onSuccess = { result ->
                userRepository.cacheUser(user = result.user)
                Result.success(result)
            },
            onFailure = { error ->
                userRepository.getCachedUser()?.let { user ->
                    Result.success(GetCurrentUserResult(user = user))
                } ?: Result.failure(error)
            }
        )
    }
}
