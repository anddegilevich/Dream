package and.degilevich.dream.shared.feature.auth.domain.api.usecase

import kotlinx.coroutines.flow.Flow

interface ObserveHasActiveSessionUseCase {
    operator fun invoke(): Flow<Boolean>
}
