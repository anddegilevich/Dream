package and.degilevich.dream.shared.feature.user.domain.impl.manager

import and.degilevich.dream.shared.feature.user.data.api.repository.UserRepository
import and.degilevich.dream.shared.feature.user.domain.api.manager.UserFetchingManager
import and.degilevich.dream.shared.feature.user.domain.api.usecase.GetCurrentUserUseCase
import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import and.degilevich.dream.shared.foundation.primitive.result.recoverResult
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.time.Duration.Companion.seconds
import kotlin.time.TimeMark
import kotlin.time.TimeSource

internal class UserFetchingManagerImpl(
    private val getCurrentUserUseCase: GetCurrentUserUseCase,
    private val userRepository: UserRepository,
    private val timeSource: TimeSource = TimeSource.Monotonic
) : UserFetchingManager {

    private val mutex = Mutex()

    private var lastUpdateMark: TimeMark? = null

    override suspend fun fetch(): Result<UserData> = mutex.withLock {
        if (isDebouncing()) {
            userRepository.getCachedUser().recoverResult { fetchUser() }
        } else {
            fetchUser()
        }
    }

    private suspend fun fetchUser(): Result<UserData> {
        return getCurrentUserUseCase().map { result ->
            result.user
        }.onSuccess {
            lastUpdateMark = timeSource.markNow()
        }
    }

    private fun isDebouncing(): Boolean {
        val elapsed = lastUpdateMark?.elapsedNow() ?: return false
        return elapsed < DEBOUNCE_TIMEOUT
    }

    private companion object {
        val DEBOUNCE_TIMEOUT = 30.seconds
    }
}
