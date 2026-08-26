package and.degilevich.dream.shared.feature.auth.domain.impl.usecase

import and.degilevich.dream.shared.feature.auth.data.test.repository.FakeAuthRepository
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class LoginUseCaseImplTest {

    @Test
    fun `invoke - repository logs in - returns its success unchanged`() = runTest {
        val useCase = LoginUseCaseImpl(
            authRepository = FakeAuthRepository(onLogin = { Result.success(Unit) })
        )

        useCase() shouldBe Result.success(Unit)
    }

    @Test
    fun `invoke - repository fails - propagates the very same failure`() = runTest {
        val failure = IllegalStateException("auth cancelled")
        val useCase = LoginUseCaseImpl(
            authRepository = FakeAuthRepository(onLogin = { Result.failure(failure) })
        )

        useCase().exceptionOrNull() shouldBe failure
    }
}
