package and.degilevich.dream.shared.feature.auth.domain.impl.usecase

import and.degilevich.dream.shared.feature.auth.data.test.repository.FakeAuthRepository
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class HasActiveSessionUseCaseImplTest {

    @Test
    fun `invoke - repository reports an active session - returns true`() = runTest {
        val useCase = HasActiveSessionUseCaseImpl(
            authRepository = FakeAuthRepository(onHasActiveSession = { true })
        )

        useCase() shouldBe true
    }

    @Test
    fun `invoke - repository reports no session - returns false`() = runTest {
        val useCase = HasActiveSessionUseCaseImpl(
            authRepository = FakeAuthRepository(onHasActiveSession = { false })
        )

        useCase() shouldBe false
    }
}
