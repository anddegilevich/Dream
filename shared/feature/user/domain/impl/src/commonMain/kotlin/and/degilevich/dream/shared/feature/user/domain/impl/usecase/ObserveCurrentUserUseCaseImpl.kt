package and.degilevich.dream.shared.feature.user.domain.impl.usecase

import and.degilevich.dream.shared.feature.user.data.api.repository.UserRepository
import and.degilevich.dream.shared.feature.user.domain.api.manager.UserFetchingManager
import and.degilevich.dream.shared.feature.user.domain.api.usecase.ObserveCurrentUserUseCase
import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.onStart

internal class ObserveCurrentUserUseCaseImpl(
    private val userRepository: UserRepository,
    private val userFetchingManager: UserFetchingManager
) : ObserveCurrentUserUseCase {

    override fun invoke(): Flow<UserData> {
        return userRepository.observeUser()
            .onStart {
                userFetchingManager.fetch()
            }.filterNotNull()
    }
}
