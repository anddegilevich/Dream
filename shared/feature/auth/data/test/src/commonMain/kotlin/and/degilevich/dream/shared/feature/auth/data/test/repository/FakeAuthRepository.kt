package and.degilevich.dream.shared.feature.auth.data.test.repository

import and.degilevich.dream.shared.feature.auth.data.api.repository.AuthRepository
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError
import kotlinx.coroutines.flow.Flow

class FakeAuthRepository(
    private val onLogin: () -> Result<Unit> = { fakeImplementationError() },
    private val onLogout: () -> Unit = { fakeImplementationError() },
    private val onHasActiveSession: () -> Boolean = { fakeImplementationError() },
    private val onObserveHasActiveSession: () -> Flow<Boolean> = { fakeImplementationError() }
) : AuthRepository {

    override suspend fun login(): Result<Unit> = onLogin()

    override suspend fun logout() = onLogout()

    override suspend fun hasActiveSession(): Boolean = onHasActiveSession()

    override fun observeHasActiveSession(): Flow<Boolean> = onObserveHasActiveSession()
}
