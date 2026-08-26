package and.degilevich.dream.shared.feature.auth.domain.impl.usecase

import and.degilevich.dream.shared.feature.auth.data.test.repository.FakeAuthRepository
import app.cash.turbine.test
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class ObserveHasActiveSessionUseCaseImplTest {

    @Test
    fun `invoke - repository emits a session state - forwards it unchanged`() = runTest {
        val useCase = ObserveHasActiveSessionUseCaseImpl(
            authRepository = FakeAuthRepository(onObserveHasActiveSession = { flowOf(true) })
        )

        useCase().test {
            awaitItem() shouldBe true
            awaitComplete()
        }
    }

    @Test
    fun `invoke - repository emits several states - forwards every one of them`() = runTest {
        val useCase = ObserveHasActiveSessionUseCaseImpl(
            authRepository = FakeAuthRepository(
                onObserveHasActiveSession = { flowOf(false, true, false) }
            )
        )

        useCase().test {
            awaitItem() shouldBe false
            awaitItem() shouldBe true
            awaitItem() shouldBe false
            awaitComplete()
        }
    }
}
