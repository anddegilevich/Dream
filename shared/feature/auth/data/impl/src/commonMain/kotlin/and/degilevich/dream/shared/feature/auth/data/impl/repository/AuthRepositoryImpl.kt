package and.degilevich.dream.shared.feature.auth.data.impl.repository

import and.degilevich.dream.shared.core.service.api.session.SessionService
import and.degilevich.dream.shared.feature.auth.data.api.repository.AuthRepository

internal class AuthRepositoryImpl(
    private val sessionService: SessionService
) : AuthRepository {

    override suspend fun login(): Result<Unit> {
        return sessionService.login().map { }
    }

    override suspend fun logout() {
        sessionService.logout()
    }

    override suspend fun hasActiveSession(): Boolean {
        return sessionService.getActiveSession().isSuccess
    }
}
