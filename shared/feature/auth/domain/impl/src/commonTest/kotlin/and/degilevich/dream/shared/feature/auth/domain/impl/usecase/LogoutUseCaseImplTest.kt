package and.degilevich.dream.shared.feature.auth.domain.impl.usecase

import and.degilevich.dream.shared.core.db.api.database.AppDatabase
import and.degilevich.dream.shared.core.db.test.database.FakeAppDatabase
import and.degilevich.dream.shared.core.storage.api.PreferenceStorage
import and.degilevich.dream.shared.core.storage.test.FakePreferenceStorage
import and.degilevich.dream.shared.feature.auth.data.api.repository.AuthRepository
import and.degilevich.dream.shared.feature.auth.data.test.repository.FakeAuthRepository
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class LogoutUseCaseImplTest {

    @Test
    fun `invoke - ends the session`() = runTest {
        var logoutCallCount = 0
        val useCase = createUseCase(
            authRepository = FakeAuthRepository(
                onLogout = { logoutCallCount++ }
            ),
            preferenceStorage = FakePreferenceStorage(
                onClearAll = { }
            ),
            appDatabase = FakeAppDatabase(
                onClear = { }
            )
        )

        useCase()

        logoutCallCount shouldBe 1
    }

    @Test
    fun `invoke - wipes every stored preference, not just the session key`() = runTest {
        var clearAllCallCount = 0
        val clearedKeys = mutableListOf<String>()
        val useCase = createUseCase(
            authRepository = FakeAuthRepository(
                onLogout = { }
            ),
            preferenceStorage = FakePreferenceStorage(
                onClear = { key -> clearedKeys += key },
                onClearAll = { clearAllCallCount++ }
            ),
            appDatabase = FakeAppDatabase(
                onClear = { }
            )
        )

        useCase()

        clearAllCallCount shouldBe 1
        clearedKeys shouldContainExactly emptyList()
    }

    @Test
    fun `invoke - wipes every cached database table`() = runTest {
        var databaseClearCallCount = 0
        val useCase = createUseCase(
            authRepository = FakeAuthRepository(
                onLogout = { }
            ),
            preferenceStorage = FakePreferenceStorage(
                onClearAll = { }
            ),
            appDatabase = FakeAppDatabase(
                onClear = { databaseClearCallCount++ }
            )
        )

        useCase()

        databaseClearCallCount shouldBe 1
    }

    @Test
    fun `invoke - tears down the session before wiping any local state`() = runTest {
        val teardownOrder = mutableListOf<String>()
        val useCase = createUseCase(
            authRepository = FakeAuthRepository(
                onLogout = { teardownOrder += "session" }
            ),
            preferenceStorage = FakePreferenceStorage(
                onClearAll = { teardownOrder += "preferences" }
            ),
            appDatabase = FakeAppDatabase(
                onClear = { teardownOrder += "database" }
            )
        )

        useCase()

        teardownOrder shouldContainExactly listOf("session", "preferences", "database")
    }

    private fun createUseCase(
        authRepository: AuthRepository = FakeAuthRepository(),
        preferenceStorage: PreferenceStorage = FakePreferenceStorage(),
        appDatabase: AppDatabase = FakeAppDatabase()
    ): LogoutUseCaseImpl {
        return LogoutUseCaseImpl(
            authRepository = authRepository,
            preferenceStorage = preferenceStorage,
            appDatabase = appDatabase
        )
    }
}
