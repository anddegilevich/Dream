package and.degilevich.dream.shared.feature.user.data.impl.storage

import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError
import kotlinx.coroutines.flow.Flow

class FakeUserDataStorage(
    private val onSave: (UserData) -> Unit = { fakeImplementationError() },
    private val onRead: () -> Result<UserData> = { fakeImplementationError() },
    private val onReadOrNull: () -> UserData? = { fakeImplementationError() },
    private val onClear: () -> Unit = { fakeImplementationError() },
    private val onObserve: () -> Flow<UserData?> = { fakeImplementationError() }
) : UserDataStorage {

    override suspend fun save(value: UserData) = onSave(value)

    override suspend fun read(): Result<UserData> = onRead()

    override suspend fun readOrNull(): UserData? = onReadOrNull()

    override suspend fun clear() = onClear()

    override fun observe(): Flow<UserData?> = onObserve()
}
