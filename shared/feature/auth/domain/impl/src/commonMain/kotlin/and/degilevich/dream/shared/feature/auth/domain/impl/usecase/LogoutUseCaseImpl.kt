package and.degilevich.dream.shared.feature.auth.domain.impl.usecase

import and.degilevich.dream.shared.core.db.api.database.AppDatabase
import and.degilevich.dream.shared.core.storage.api.PreferenceStorage
import and.degilevich.dream.shared.feature.auth.data.api.repository.AuthRepository
import and.degilevich.dream.shared.feature.auth.domain.api.usecase.LogoutUseCase

internal class LogoutUseCaseImpl(
    private val authRepository: AuthRepository,
    private val preferenceStorage: PreferenceStorage,
    private val appDatabase: AppDatabase
) : LogoutUseCase {

    override suspend fun invoke(): Result<Unit> = runCatching {
        authRepository.logout()
        preferenceStorage.clearAll()
        appDatabase.clear()
    }
}
