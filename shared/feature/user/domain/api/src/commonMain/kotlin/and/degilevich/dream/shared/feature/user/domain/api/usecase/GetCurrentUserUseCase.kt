package and.degilevich.dream.shared.feature.user.domain.api.usecase

import and.degilevich.dream.shared.feature.user.model.core.api.method.getCurrentUser.GetCurrentUserResult

interface GetCurrentUserUseCase {
    suspend operator fun invoke(): Result<GetCurrentUserResult>
}
