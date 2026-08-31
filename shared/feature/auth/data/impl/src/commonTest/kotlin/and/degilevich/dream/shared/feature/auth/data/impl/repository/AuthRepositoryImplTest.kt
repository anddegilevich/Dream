package and.degilevich.dream.shared.feature.auth.data.impl.repository

import and.degilevich.dream.shared.core.service.api.model.SessionData
import and.degilevich.dream.shared.core.service.api.model.TokensData
import and.degilevich.dream.shared.core.service.test.session.FakeSessionService
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class AuthRepositoryImplTest {

    @Test
    fun `login - session service authenticates - succeeds without carrying the session out of the data layer`() =
        runTest {
            val repository = AuthRepositoryImpl(
                sessionService = FakeSessionService(
                    onLogin = { Result.success(activeSession()) }
                )
            )

            val result = repository.login()

            result shouldBe Result.success(Unit)
        }

    @Test
    fun `login - session service fails - propagates the very same failure`() = runTest {
        val failure = IllegalStateException("auth cancelled")
        val repository = AuthRepositoryImpl(
            sessionService = FakeSessionService(
                onLogin = { Result.failure(failure) }
            )
        )

        val result = repository.login()

        result.exceptionOrNull() shouldBe failure
    }

    @Test
    fun `logout - delegates to the session service`() = runTest {
        var logoutCallCount = 0
        val repository = AuthRepositoryImpl(
            sessionService = FakeSessionService(
                onLogout = { logoutCallCount++ }
            )
        )

        repository.logout()

        logoutCallCount shouldBe 1
    }

    @Test
    fun `hasActiveSession - session service returns a session - returns true`() = runTest {
        val repository = AuthRepositoryImpl(
            sessionService = FakeSessionService(
                onGetActiveSession = { Result.success(activeSession()) }
            )
        )

        repository.hasActiveSession() shouldBe true
    }

    @Test
    fun `hasActiveSession - session service has no session - returns false rather than raising`() = runTest {
        val repository = AuthRepositoryImpl(
            sessionService = FakeSessionService(
                onGetActiveSession = { Result.failure(IllegalStateException("no session")) }
            )
        )

        repository.hasActiveSession() shouldBe false
    }

    private fun activeSession(): SessionData {
        return SessionData(
            tokens = TokensData(
                accessToken = "access-token",
                refreshToken = "refresh-token"
            )
        )
    }
}
