package and.degilevich.dream.shared.feature.user.domain.api.usecase

import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import kotlinx.coroutines.flow.Flow

interface ObserveCurrentUserUseCase {
    operator fun invoke(): Flow<UserData>
}
