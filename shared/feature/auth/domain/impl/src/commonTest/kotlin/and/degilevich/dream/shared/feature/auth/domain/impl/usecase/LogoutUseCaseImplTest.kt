package and.degilevich.dream.shared.feature.auth.domain.impl.usecase

import and.degilevich.dream.shared.feature.auth.data.test.repository.FakeAuthRepository
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class LogoutUseCaseImplTest {

    @Test
    fun `invoke - delegates to the repository`() = runTest {
        var logoutCallCount = 0
        val useCase = LogoutUseCaseImpl(
            authRepository = FakeAuthRepository(onLogout = { logoutCallCount++ })
        )

        useCase()

        logoutCallCount shouldBe 1
    }
}
