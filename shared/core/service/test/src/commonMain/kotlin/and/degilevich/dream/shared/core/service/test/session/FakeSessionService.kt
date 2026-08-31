package and.degilevich.dream.shared.core.service.test.session

import and.degilevich.dream.shared.core.service.api.model.SessionData
import and.degilevich.dream.shared.core.service.api.session.SessionService
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeSessionService(
    private val onLogin: () -> Result<SessionData> = { fakeImplementationError() },
    private val onLogout: () -> Unit = { fakeImplementationError() },
    private val onGetActiveSession: () -> Result<SessionData> = { fakeImplementationError() }
) : SessionService {

    override suspend fun login(): Result<SessionData> {
        return onLogin()
    }

    override suspend fun logout() {
        onLogout()
    }

    override suspend fun getActiveSession(): Result<SessionData> {
        return onGetActiveSession()
    }
}
